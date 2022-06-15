package com.fawaz2.recipe.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.fawaz2.recipe.*
import com.fawaz2.recipe.Adapters.CategoryItemsAdapter
import com.fawaz2.recipe.Adapters.CustomViewHolder
import com.fawaz2.recipe.Models.CategoryItemsFeed
import com.fawaz2.recipe.Profile.ProfileActivity
import com.fawaz2.recipe.Search.RecipeSearchActivity
import com.fawaz2.recipe.Search.SelectIngredientActivity
import com.google.android.material.navigation.NavigationView
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.category_content.*
import okhttp3.*
import java.io.IOException

class CategoryItemsActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener  {

    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    lateinit var textview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_items)

        fetchJson()


        recyclerView_category.layoutManager = LinearLayoutManager(this)
       // recyclerView_category.adapter = CategoryItemsAdapter()

        val navBarTitle = intent.getStringExtra(CustomViewHolder.CATEGORY_TITLE_KEY)

       // val categoryItemUrl = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + navBarTitle

       // println(categoryItemUrl)

        toolbar = findViewById(R.id.toolbar)
        toolbar.title = navBarTitle

        textview = findViewById(R.id.categoryItemsName)
        textview.text = navBarTitle
        setSupportActionBar(toolbar)



        drawerLayout = findViewById(R.id.drawerLayout)
        navView = findViewById(R.id.navView)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.latestRecipes -> {
                Toast.makeText(this, "Latest Recipes", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity:: class.java)
                this.startActivity(intent)
            }
            R.id.Favourites -> {
                Toast.makeText(this, "Favourites", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, FavouritesActivity:: class.java)
                this.startActivity(intent)

            }
            R.id.Categories -> {
                Toast.makeText(this, "Categories", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, CategoryActivity:: class.java)
                this.startActivity(intent)

            }
            R.id.RecipeSearch -> {
                Toast.makeText(this, "Recipes Search", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, RecipeSearchActivity:: class.java)
                this.startActivity(intent)
            }
            R.id.ShoppingList -> {
                Toast.makeText(this, "Shopping List", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ShoppingListActivity :: class.java)
                this.startActivity(intent)
            }

            R.id.SearchByIngredients -> {
                Toast.makeText(this, "Search By Ingredients", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SelectIngredientActivity :: class.java)
                this.startActivity(intent)
            }
            R.id.Profile -> {
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ProfileActivity:: class.java)
                this.startActivity(intent)
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true


    }

    private fun fetchJson(){
        val categoryItem = intent.getStringExtra(CustomViewHolder.CATEGORY_TITLE_KEY)
        val categoryItemUrl = "https://www.themealdb.com/api/json/v1/1/filter.php?c="+ categoryItem

        val client = OkHttpClient()
        val request = Request.Builder().url(categoryItemUrl).build()

        client.newCall(request).enqueue(object :Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response?.body()?.string()
                val gson = GsonBuilder().create()

                val categoryItemsFeed = gson.fromJson(body, CategoryItemsFeed:: class.java)

                runOnUiThread{
                    recyclerView_category.adapter = CategoryItemsAdapter(categoryItemsFeed)
                }

                println(body)

            }

            override fun onFailure(call: Call, e: IOException) {
            }
        })

    }


}

