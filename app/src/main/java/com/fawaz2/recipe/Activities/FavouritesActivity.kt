package com.fawaz2.recipe.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.fawaz2.recipe.Adapters.FavouritesAdapter
import com.fawaz2.recipe.Models.Meals
import com.fawaz2.recipe.Profile.ProfileActivity
import com.fawaz2.recipe.R
import com.fawaz2.recipe.Search.RecipeSearchActivity
import com.fawaz2.recipe.Search.SelectIngredientActivity
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.all_recipe_content_main.latestItemsName
import kotlinx.android.synthetic.main.favourite_content_main.*


class FavouritesActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourites)


        toolbar = findViewById(R.id.toolbar)
        // setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawerLayout)
        navView = findViewById(R.id.navView)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        latestItemsName.text = "Favourites"

        val currentUser = FirebaseAuth.getInstance().currentUser
        var uid: String? = null
        val firebaseInstance = FirebaseDatabase.getInstance()
        if (currentUser != null){
            uid = currentUser.uid
        }
        val firebasedatabase = firebaseInstance!!
            .getReference("/Users/${uid}/Meals")

        val eventListener: ValueEventListener
        eventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val mealArray = ArrayList<Meals>()
                for(data in dataSnapshot.children){
                    val meals = data.getValue(Meals::class.java)
                    mealArray.add(meals as Meals)

                }
                if(mealArray.size > 0){
                    fav_gridView.adapter =
                        FavouritesAdapter(
                            this@FavouritesActivity, mealArray)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        }
        firebasedatabase.addListenerForSingleValueEvent(eventListener)

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
                val intent = Intent(this, FavouritesActivity :: class.java)
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


}
