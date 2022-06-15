package com.fawaz2.recipe.Search

import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.fawaz2.recipe.Adapters.SelectIngredientsAdapter
import com.fawaz2.recipe.R
import kotlinx.android.synthetic.main.activity_select_ingredient.*
import java.io.InputStream
import java.nio.charset.Charset

class SelectIngredientActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_ingredient)

        rec_Search.layoutManager = LinearLayoutManager(this)

        val toolBar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolBar)

        val searchEditText = findViewById<EditText>(R.id.search_edit_text)
        searchEditText.selectAll()

        val `is`: InputStream = this.resources.openRawResource(R.raw.ingredients)

        var content = `is`.readBytes().toString(Charset.defaultCharset())
        var ingList = content.split("\n").toTypedArray()

        rec_Search.adapter = SelectIngredientsAdapter(ingList)


        //Making the abilty to listen to when text change in search bar
        val searchText = findViewById<EditText>(R.id.search_edit_text)
        searchText.addTextChangedListener(object : TextWatcher
        {
            override fun afterTextChanged(s: Editable?) {

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               // searchJson(s.toString())
                var text = s.toString()
                var filtered = arrayOf<String>()
                for(item in ingList){
                    if (item.toString().contains(text, ignoreCase = true)){
                        filtered = append(filtered, item)
                    }
                }
                rec_Search.adapter = SelectIngredientsAdapter(filtered)
            }

        })

        searchText.setOnEditorActionListener{s, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                searchJson(s.text.toString())
                true
            } else {
                false
            }
        }


        // Verify the action and get the query
        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                doMySearch(query)
            }
        }
    }

    /*
 * This method fetches the information from the online API
 * */
    fun searchJson(text: String){


    }

    fun append(arr: Array<String>, element: String): Array<String> {
        val list: MutableList<String> = arr.toMutableList()
        list.add(element)
        return list.toTypedArray()
    }

    private fun doMySearch(query: String) {}
}

