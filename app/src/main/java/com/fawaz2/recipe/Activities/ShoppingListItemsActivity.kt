package com.fawaz2.recipe.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.fawaz2.recipe.R
import com.google.android.material.navigation.NavigationView

class ShoppingListItemsActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_s_hopping_list_items)

        val intent: Intent = getIntent()

        val i1 = intent.getStringExtra("INGREDIENTS_1")
        val i2 = intent.getStringExtra("INGREDIENTS_2")
        val i3 = intent.getStringExtra("INGREDIENTS_3")
        val i4 = intent.getStringExtra("INGREDIENTS_4")
        val i5 = intent.getStringExtra("INGREDIENTS_5")
        val i6 = intent.getStringExtra("INGREDIENTS_6")
        val i7 = intent.getStringExtra("INGREDIENTS1_7")
        val i8 = intent.getStringExtra("INGREDIENTS_8")
        val i9 = intent.getStringExtra("INGREDIENTS_9")
        val i10 = intent.getStringExtra("INGREDIENTS_10")
        val i11 = intent.getStringExtra("INGREDIENTS_11")
        val i12 = intent.getStringExtra("INGREDIENTS_12")
        val i13 = intent.getStringExtra("INGREDIENTS_13")
        val i14 = intent.getStringExtra("INGREDIENTS_14")
        val i15 = intent.getStringExtra("INGREDIENTS_15")
        val i16 = intent.getStringExtra("INGREDIENTS_16")
        val i17 = intent.getStringExtra("INGREDIENTS_17")
        val i18 =  intent.getStringExtra("INGREDIENTS_18")
        val i19 = intent.getStringExtra("INGREDIENTS_19")
        val i20 = intent.getStringExtra("INGREDIENTS_20")

        //ingredients
        val ingredients1 = findViewById<TextView>(R.id.ingredients1)
        val ingredients2 = findViewById<TextView>(R.id.ingredients2)
        val ingredients3 = findViewById<TextView>(R.id.ingredients3)
        val ingredients4 = findViewById<TextView>(R.id.ingredients4)
        val ingredients5 = findViewById<TextView>(R.id.ingredients5)
        val ingredients6 = findViewById<TextView>(R.id.ingredients6)
        val ingredients7 = findViewById<TextView>(R.id.ingredients7)
        val ingredients8 = findViewById<TextView>(R.id.ingredients8)
        val ingredients9 = findViewById<TextView>(R.id.ingredients9)
        val ingredients10 = findViewById<TextView>(R.id.ingredients10)
        val ingredients11 = findViewById<TextView>(R.id.ingredients11)
        val ingredients12 = findViewById<TextView>(R.id.ingredients12)
        val ingredients13 = findViewById<TextView>(R.id.ingredients13)
        val ingredients14 = findViewById<TextView>(R.id.ingredients14)
        val ingredients15 = findViewById<TextView>(R.id.ingredients15)
        val ingredients16 = findViewById<TextView>(R.id.ingredients16)
        val ingredients17 = findViewById<TextView>(R.id.ingredients17)
        val ingredients18 = findViewById<TextView>(R.id.ingredients18)
        val ingredients19 = findViewById<TextView>(R.id.ingredients19)
        val ingredients20 = findViewById<TextView>(R.id.ingredients20)

        //set text to Ingredients text view
        ingredients1?.text = i1
        ingredients2?.text = i2
        ingredients3?.text = i3
        ingredients4?.text = i4
        ingredients5?.text = i5
        ingredients6?.text = i6
        ingredients7?.text = i7
        ingredients8?.text = i8
        ingredients9?.text = i9
        ingredients10?.text = i10
        ingredients11?.text = i11
        ingredients12?.text = i12
        ingredients13?.text = i13
        ingredients14?.text = i14
        ingredients15?.text = i15
        ingredients16?.text = i16
        ingredients17?.text = i17
        ingredients18?.text = i18
        ingredients19?.text = i19
        ingredients20?.text = i20

        /*
     * Remove CheckBox when no Text is Given.
     * */
        when(ingredients1?.text) {
            " " -> ingredients1.visibility = View.GONE
            null.toString() -> ingredients1?.visibility = View.GONE
            "" -> ingredients1.visibility = View.GONE
            else -> ingredients1.visibility = View.VISIBLE
        }
        when(ingredients2?.text) {
            " " -> ingredients2.visibility = View.GONE
            null.toString() -> ingredients2?.visibility = View.GONE
            "" -> ingredients2.visibility = View.GONE
            else -> ingredients2.visibility = View.VISIBLE
        }
        when(ingredients3?.text) {
            " " -> ingredients3.visibility = View.GONE
            null.toString() -> ingredients3?.visibility = View.GONE
            "" -> ingredients3.visibility = View.GONE
            else -> ingredients3.visibility = View.VISIBLE
        }
        when(ingredients4?.text) {
            " " -> ingredients4.visibility = View.GONE
            null.toString() -> ingredients4?.visibility = View.GONE
            "" -> ingredients4.visibility = View.GONE
            else -> ingredients4.visibility = View.VISIBLE
        }
        when(ingredients5?.text) {
            " " -> ingredients5.visibility = View.GONE
            null.toString() -> ingredients5?.visibility = View.GONE
            "" -> ingredients5.visibility = View.GONE
            else -> ingredients5.visibility = View.VISIBLE
        }
        when(ingredients6?.text) {
            " " -> ingredients6.visibility = View.GONE
            null.toString() -> ingredients6?.visibility = View.GONE
            "" -> ingredients6.visibility = View.GONE
            else -> ingredients6.visibility = View.VISIBLE
        }
        when(ingredients7?.text) {
            " " -> ingredients7.visibility = View.GONE
            null.toString() -> ingredients7?.visibility = View.GONE
            "" -> ingredients7.visibility = View.GONE
            else -> ingredients7.visibility = View.VISIBLE
        }
        when(ingredients8?.text) {
            " " -> ingredients8.visibility = View.GONE
            null.toString() -> ingredients8?.visibility = View.GONE
            "" -> ingredients8.visibility = View.GONE
            else -> ingredients8.visibility = View.VISIBLE
        }
        when(ingredients9?.text) {
            " " -> ingredients9.visibility = View.GONE
            null.toString() -> ingredients9?.visibility = View.GONE
            "" -> ingredients9.visibility = View.GONE
            else -> ingredients9.visibility = View.VISIBLE
        }
        when(ingredients10?.text) {
            " " -> ingredients10.visibility = View.GONE
            null.toString() -> ingredients10?.visibility = View.GONE
            "" -> ingredients10.visibility = View.GONE
            else -> ingredients10.visibility = View.VISIBLE
        }
        when(ingredients11?.text) {
            " " -> ingredients11.visibility = View.GONE
            null.toString() -> ingredients11?.visibility = View.GONE
            "" -> ingredients11.visibility = View.GONE
            else -> ingredients11.visibility = View.VISIBLE
        }
        when(ingredients12?.text) {
            " " -> ingredients12.visibility = View.GONE
            null.toString() -> ingredients12?.visibility = View.GONE
            "" -> ingredients12.visibility = View.GONE
            else -> ingredients12.visibility = View.VISIBLE
        }
        when(ingredients13?.text) {
            " " -> ingredients13.visibility = View.GONE
            null.toString() -> ingredients13?.visibility = View.GONE
            "" -> ingredients13.visibility = View.GONE
            else -> ingredients13.visibility = View.VISIBLE
        }
        when(ingredients14?.text) {
            " " -> ingredients14.visibility = View.GONE
            null.toString() -> ingredients14?.visibility = View.GONE
            "" -> ingredients14.visibility = View.GONE
            else -> ingredients14.visibility = View.VISIBLE
        }
        when(ingredients15?.text) {
            " " -> ingredients15.visibility = View.GONE
            null.toString() -> ingredients15?.visibility = View.GONE
            "" -> ingredients15.visibility = View.GONE
            else -> ingredients15.visibility = View.VISIBLE
        }
        when(ingredients16?.text) {
            " " -> ingredients16.visibility = View.GONE
            null.toString() -> ingredients16?.visibility = View.GONE
            "" -> ingredients16.visibility = View.GONE
            else -> ingredients16.visibility = View.VISIBLE
        }
        when(ingredients17?.text) {
            " " -> ingredients17.visibility = View.GONE
            null.toString() -> ingredients17?.visibility = View.GONE
            "" -> ingredients17.visibility = View.GONE
            else -> ingredients17.visibility = View.VISIBLE
        }
        when(ingredients18?.text) {
            " " -> ingredients18.visibility = View.GONE
            null.toString() -> ingredients18?.visibility = View.GONE
            "" -> ingredients18.visibility = View.GONE
            else -> ingredients18.visibility = View.VISIBLE
        }
        when(ingredients19?.text) {
            " " -> ingredients19.visibility = View.GONE
            null.toString() -> ingredients19?.visibility = View.GONE
            "" -> ingredients19.visibility = View.GONE
            else -> ingredients19.visibility = View.VISIBLE
        }
        when(ingredients20?.text) {
            " " -> ingredients20.visibility = View.GONE
            null.toString() -> ingredients20?.visibility = View.GONE
            "" -> ingredients20.visibility = View.GONE
            else -> ingredients20.visibility = View.VISIBLE
        }

        
    }

}