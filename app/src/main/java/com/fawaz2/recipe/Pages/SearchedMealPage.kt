package com.fawaz2.recipe.Pages

import RecipeDetailsAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fawaz2.recipe.Models.RecipeFeed
import com.fawaz2.recipe.R
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.recipe_details_content.*
import okhttp3.*
import java.io.IOException

class SearchedMealPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)

        val mealId = intent.getIntExtra("MEAL_ID_KEY", -1)
        val mealURL = "https://www.themealdb.com/api/json/v1/1/lookup.php?i="+ mealId



        val client = OkHttpClient()
        val request = Request.Builder().url(mealURL).build()
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response?.body()?.string()

                val gson = GsonBuilder().create()

                val mealFeed =  gson.fromJson(body, RecipeFeed:: class.java)

                runOnUiThread{

                    rel_recipe.adapter = RecipeDetailsAdapter(this@SearchedMealPage, mealFeed)
                }


                println(body)

            }
            override fun onFailure(call: Call, e: IOException) {

            }

        })

    }

}

