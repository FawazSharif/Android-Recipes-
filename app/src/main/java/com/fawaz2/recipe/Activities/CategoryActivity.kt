package com.fawaz2.recipe.Activities

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
import com.fawaz2.recipe.*
import com.fawaz2.recipe.Adapters.CategoryAdapter
import com.fawaz2.recipe.Models.CategoryFeed
import com.fawaz2.recipe.Profile.ProfileActivity
import com.fawaz2.recipe.Search.RecipeSearchActivity
import com.fawaz2.recipe.Search.SelectIngredientActivity
import com.google.android.material.navigation.NavigationView
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.category_content.*
import okhttp3.*
import java.io.IOException

class CategoryActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        recyclerView_category.layoutManager = LinearLayoutManager(this)
       // recyclerView_category.adapter = CategoryAdapter()

        fetchJason()

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

    fun fetchJason(){
        println("Attempting to fetch Jason")

        val url = "https://www.themealdb.com/api/json/v1/1/categories.php"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback{

            override fun onResponse(call: Call, response: Response) {
                val body = response?.body()?.string()
                println(body)

                val gson = GsonBuilder().create()

                val categoryFeed = gson.fromJson(body, CategoryFeed::class.java)

                runOnUiThread{
                    recyclerView_category.adapter = CategoryAdapter(categoryFeed)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute")
            }
        })
    }

}


