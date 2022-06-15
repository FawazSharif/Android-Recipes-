package com.fawaz2.recipe.Search

import com.fawaz2.recipe.Adapters.LatestRecipeAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.fawaz2.recipe.Activities.CategoryActivity
import com.fawaz2.recipe.Activities.FavouritesActivity
import com.fawaz2.recipe.Activities.MainActivity
import com.fawaz2.recipe.Activities.ShoppingListActivity
import com.fawaz2.recipe.Profile.ProfileActivity
import com.fawaz2.recipe.R
import com.fawaz2.recipe.Models.RecipeFeed
import com.google.android.material.navigation.NavigationView
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.all_recipe_content_main.*
import okhttp3.*
import java.io.IOException

class MealsByIngredients : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meals_by_ingredients)

        fetchJson()

        recyclerView_latest.layoutManager = LinearLayoutManager(this)

        toolbar = findViewById(R.id.toolbar)
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

    /*
    * Method to change activity when an item from the navigation drawer is selected
    * */
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
                val intent = Intent(this, ShoppingListActivity:: class.java)
                this.startActivity(intent)
            }

            R.id.SearchByIngredients -> {
                Toast.makeText(this, "Search By Ingredients clicked", Toast.LENGTH_SHORT).show()
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


    /*
    * This method fetches the information from the online database of recipes
    * */
    fun fetchJson(){
        println("fetching Json")
        val intent: Intent = getIntent()

        val ingredientsSearched = intent.getStringExtra("INGREDIENT_TITLE")
      //  ingredientsSearched.replace("\\s".toRegex(), "")
        //ingredientsSearched.trim()
        println("INGREDIENTS "+ ingredientsSearched)

        val url = "https://www.themealdb.com/api/json/v2/1/filter.php?i=${ingredientsSearched}"

        val  request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request). enqueue(object: Callback {

            //This is what happens on response when fatching the Json
            override fun onResponse(call: Call, response: Response) {
                val body = response?.body()?.string()
                println(body)

                val gson = GsonBuilder().create()

                val recipeFeed = gson.fromJson(body, RecipeFeed::class.java)

                runOnUiThread {
                    recyclerView_latest.adapter = LatestRecipeAdapter(recipeFeed)
                }

            }
            //when it fails to call Json
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
    }

}
