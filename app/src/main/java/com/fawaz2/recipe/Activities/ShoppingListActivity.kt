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
import com.fawaz2.recipe.Adapters.ShoppingListAdapter
import com.fawaz2.recipe.Models.ShoppingList
import com.fawaz2.recipe.Profile.ProfileActivity
import com.fawaz2.recipe.R
import com.fawaz2.recipe.Search.RecipeSearchActivity
import com.fawaz2.recipe.Search.SelectIngredientActivity
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.shoppinglist_content.*

class ShoppingListActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)

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


        val currentUser = FirebaseAuth.getInstance().currentUser
        var uid: String? = null
        val firebaseInstance = FirebaseDatabase.getInstance()
        if (currentUser != null){
            uid = currentUser.uid
        }
        val firebasedatabase = firebaseInstance!!
            .getReference("/Users/${uid}/Shopping List")

        val eventListener: ValueEventListener
        eventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val shoppinListArray = ArrayList<ShoppingList>()
                for(data in dataSnapshot.children){
                    val shoppingList = data.getValue(ShoppingList::class.java)
                    shoppinListArray.add(shoppingList as ShoppingList)

                }
                if(shoppinListArray.size > 0){
                    shoppingList_gridView.adapter =
                        ShoppingListAdapter(
                            this@ShoppingListActivity, shoppinListArray)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        }
        firebasedatabase.addListenerForSingleValueEvent(eventListener)

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