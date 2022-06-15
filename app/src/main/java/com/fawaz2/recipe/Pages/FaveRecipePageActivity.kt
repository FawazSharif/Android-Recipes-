package com.fawaz2.recipe.Pages

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.fawaz2.recipe.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.squareup.picasso.Picasso

class FaveRecipePageActivity : AppCompatActivity()  {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fave_recipe_page)

        val intent: Intent = getIntent()

        val mealName = intent.getStringExtra("MEAL_NAME")
        val category =  intent.getStringExtra("CATEGORY")
        val country = intent.getStringExtra("COUNTRY")
        val instructions = intent.getStringExtra("INSTRUCTIONS")


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

        val m1 = intent.getStringExtra("MEASUREMENT_1")
        val m2 = intent.getStringExtra("MEASUREMENT_2")
        val m3 = intent.getStringExtra("MEASUREMENT_3")
        val m4 = intent.getStringExtra("MEASUREMENT_4")
        val m5 = intent.getStringExtra("MEASUREMENT_5")
        val m6 = intent.getStringExtra("MEASUREMENT_6")
        val m7 = intent.getStringExtra("MEASUREMENT_7")
        val m8 = intent.getStringExtra("MEASUREMENT_8")
        val m9 = intent.getStringExtra("MEASUREMENT_9")
        val m10 = intent.getStringExtra("MEASUREMENT_10")
        val m11 = intent.getStringExtra("MEASUREMENT_11")
        val m12 = intent.getStringExtra("MEASUREMENT_12")
        val m13 = intent.getStringExtra("MEASUREMENT_13")
        val m14 = intent.getStringExtra("MEASUREMENT_14")
        val m15 = intent.getStringExtra("MEASUREMENT_15")
        val m16 = intent.getStringExtra("MEASUREMENT_16")
        val m17 = intent.getStringExtra("MEASUREMENT_17")
        val m18 = intent.getStringExtra("MEASUREMENT_18")
        val m19 = intent.getStringExtra("MEASUREMENT_19")
        val m20 = intent.getStringExtra("MEASUREMENT_20")

        val sc = intent.getStringExtra("SOURCE")
        val yt = intent.getStringExtra("YOUTUBE")
        val img = intent.getStringExtra("IMAGE")


        // To find the textViews and ImageViews in the activity_fav_recipe_page.xml file
        val recipeName = findViewById<TextView>(R.id.mealName)
        val imageView = findViewById<ImageView>(R.id.recipeImage)
        val categoryName =findViewById<TextView>(R.id.category)
        val countryName = findViewById<TextView>(R.id.country)
        val instructionsView =findViewById<TextView>(R.id.instructions)

        val youTube = findViewById<FloatingActionButton>(R.id.youtube)
        val source = findViewById<FloatingActionButton>(R.id.source)
        val shareButton = findViewById<FloatingActionButton>(R.id.shareButton)
        val favBtn = findViewById<FloatingActionButton>(R.id.saveButton)
        favBtn.visibility = View.GONE

        //ingredients
        val ingredients1 = findViewById<CheckBox>(R.id.ingredients1)
        val ingredients2 = findViewById<CheckBox>(R.id.ingredients2)
        val ingredients3 = findViewById<CheckBox>(R.id.ingredients3)
        val ingredients4 = findViewById<CheckBox>(R.id.ingredients4)
        val ingredients5 = findViewById<CheckBox>(R.id.ingredients5)
        val ingredients6 = findViewById<CheckBox>(R.id.ingredients6)
        val ingredients7 = findViewById<CheckBox>(R.id.ingredients7)
        val ingredients8 = findViewById<CheckBox>(R.id.ingredients8)
        val ingredients9 = findViewById<CheckBox>(R.id.ingredients9)
        val ingredients10 = findViewById<CheckBox>(R.id.ingredients10)
        val ingredients11 = findViewById<CheckBox>(R.id.ingredients11)
        val ingredients12 = findViewById<CheckBox>(R.id.ingredients12)
        val ingredients13 = findViewById<CheckBox>(R.id.ingredients13)
        val ingredients14 = findViewById<CheckBox>(R.id.ingredients14)
        val ingredients15 = findViewById<CheckBox>(R.id.ingredients15)
        val ingredients16 = findViewById<CheckBox>(R.id.ingredients16)
        val ingredients17 = findViewById<CheckBox>(R.id.ingredients17)
        val ingredients18 = findViewById<CheckBox>(R.id.ingredients18)
        val ingredients19 = findViewById<CheckBox>(R.id.ingredients19)
        val ingredients20 = findViewById<CheckBox>(R.id.ingredients20)

        //measurements
        val measurement1 = findViewById<TextView>(R.id.measurement1)
        val measurement2 = findViewById<TextView>(R.id.measurement2)
        val measurement3 = findViewById<TextView>(R.id.measurement3)
        val measurement4 = findViewById<TextView>(R.id.measurement4)
        val measurement5 = findViewById<TextView>(R.id.measurement5)
        val measurement6 = findViewById<TextView>(R.id.measurement6)
        val measurement7 = findViewById<TextView>(R.id.measurement7)
        val measurement8 = findViewById<TextView>(R.id.measurement8)
        val measurement9 = findViewById<TextView>(R.id.measurement9)
        val measurement10 = findViewById<TextView>(R.id.measurement10)
        val measurement11 = findViewById<TextView>(R.id.measurement11)
        val measurement12 = findViewById<TextView>(R.id.measurement12)
        val measurement13 = findViewById<TextView>(R.id.measurement13)
        val measurement14 = findViewById<TextView>(R.id.measurement14)
        val measurement15 = findViewById<TextView>(R.id.measurement15)
        val measurement16 = findViewById<TextView>(R.id.measurement16)
        val measurement17 = findViewById<TextView>(R.id.measurement17)
        val measurement18 = findViewById<TextView>(R.id.measurement18)
        val measurement19 = findViewById<TextView>(R.id.measurement19)
        val measurement20 = findViewById<TextView>(R.id.measurement20)

        recipeName.text = mealName
        categoryName.text = category
        countryName.text = country
        instructionsView.text = instructions

        ingredients1.text = i1
        ingredients2.text = i2
        ingredients3.text = i3
        ingredients4.text = i4
        ingredients5.text = i5
        ingredients6.text = i6
        ingredients7.text = i7
        ingredients8.text = i8
        ingredients9.text = i9
        ingredients10.text = i10
        ingredients11.text = i11
        ingredients12.text = i12
        ingredients13.text = i13
        ingredients14.text = i14
        ingredients15.text = i15
        ingredients16.text = i16
        ingredients17.text = i17
        ingredients18.text = i18
        ingredients19.text = i19
        ingredients20.text = i20

        measurement1.text = m1
        measurement2.text = m2
        measurement3.text = m3
        measurement4.text = m4
        measurement5.text = m5
        measurement6.text = m6
        measurement7.text = m7
        measurement8.text = m8
        measurement9.text = m9
        measurement10.text = m10
        measurement11.text = m11
        measurement12.text = m12
        measurement13.text = m13
        measurement14.text = m14
        measurement15.text = m15
        measurement16.text = m16
        measurement17.text = m17
        measurement18.text = m18
        measurement19.text = m19
        measurement20.text = m20






        // on click listeners.

        //Open webPage for the source
        source?.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(sc))
            startActivity(intent)
        }

        imageView?.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(yt));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setPackage("com.google.android.youtube");
            startActivity(intent)

        }

        youTube?.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(yt));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setPackage("com.google.android.youtube");
            startActivity(intent)
        }

        shareButton?.setOnClickListener {
            val shareIntent = Intent().apply {
                this.action = Intent.ACTION_SEND
                this.putExtra(
                    Intent.EXTRA_TEXT, "Here's a meal you could try an make at: ${source}" +
                            "and also watch a vidoe on how to prepare it at: ${youTube}")
                this.type = "text/plain"
            }
            this.startActivity(shareIntent)
        }


        /*
        * Remove CheckBox when no Text is Given.
        * */
        when(ingredients1?.text) {
            " " -> ingredients1.visibility = View.GONE
            null -> ingredients1?.visibility = View.GONE
            "" -> ingredients1.visibility = View.GONE
            else -> ingredients1.visibility = View.VISIBLE
        }
        when(ingredients2?.text) {
            " " -> ingredients2.visibility = View.GONE
            null -> ingredients2?.visibility = View.GONE
            "" -> ingredients2.visibility = View.GONE
            else -> ingredients2.visibility = View.VISIBLE
        }
        when(ingredients3?.text) {
            " " -> ingredients3.visibility = View.GONE
            null -> ingredients3?.visibility = View.GONE
            "" -> ingredients3.visibility = View.GONE
            else -> ingredients3.visibility = View.VISIBLE
        }
        when(ingredients4?.text) {
            " " -> ingredients4.visibility = View.GONE
            null -> ingredients4?.visibility = View.GONE
            "" -> ingredients4.visibility = View.GONE
            else -> ingredients4.visibility = View.VISIBLE
        }
        when(ingredients5?.text) {
            " " -> ingredients5.visibility = View.GONE
            null -> ingredients5?.visibility = View.GONE
            "" -> ingredients5.visibility = View.GONE
            else -> ingredients5.visibility = View.VISIBLE
        }
        when(ingredients6?.text) {
            " " -> ingredients6.visibility = View.GONE
            null -> ingredients6?.visibility = View.GONE
            "" -> ingredients6.visibility = View.GONE
            else -> ingredients6.visibility = View.VISIBLE
        }
        when(ingredients7?.text) {
            " " -> ingredients7.visibility = View.GONE
            null -> ingredients7?.visibility = View.GONE
            "" -> ingredients7.visibility = View.GONE
            else -> ingredients7.visibility = View.VISIBLE
        }
        when(ingredients8?.text) {
            " " -> ingredients8.visibility = View.GONE
            null -> ingredients8?.visibility = View.GONE
            "" -> ingredients8.visibility = View.GONE
            else -> ingredients8.visibility = View.VISIBLE
        }
        when(ingredients9?.text) {
            " " -> ingredients9.visibility = View.GONE
            null -> ingredients9?.visibility = View.GONE
            "" -> ingredients9.visibility = View.GONE
            else -> ingredients9.visibility = View.VISIBLE
        }
        when(ingredients10?.text) {
            " " -> ingredients10.visibility = View.GONE
            null -> ingredients10?.visibility = View.GONE
            "" -> ingredients10.visibility = View.GONE
            else -> ingredients10.visibility = View.VISIBLE
        }
        when(ingredients11?.text) {
            " " -> ingredients11.visibility = View.GONE
            null -> ingredients11?.visibility = View.GONE
            "" -> ingredients11.visibility = View.GONE
            else -> ingredients11.visibility = View.VISIBLE
        }
        when(ingredients12?.text) {
            " " -> ingredients12.visibility = View.GONE
            null -> ingredients12?.visibility = View.GONE
            "" -> ingredients12.visibility = View.GONE
            else -> ingredients12.visibility = View.VISIBLE
        }
        when(ingredients13?.text) {
            " " -> ingredients13.visibility = View.GONE
            null -> ingredients13?.visibility = View.GONE
            "" -> ingredients13.visibility = View.GONE
            else -> ingredients13.visibility = View.VISIBLE
        }
        when(ingredients14?.text) {
            " " -> ingredients14.visibility = View.GONE
            null -> ingredients14?.visibility = View.GONE
            "" -> ingredients14.visibility = View.GONE
            else -> ingredients14.visibility = View.VISIBLE
        }
        when(ingredients15?.text) {
            " " -> ingredients15.visibility = View.GONE
            null -> ingredients15?.visibility = View.GONE
            "" -> ingredients15.visibility = View.GONE
            else -> ingredients15.visibility = View.VISIBLE
        }
        when(ingredients16?.text) {
            " " -> ingredients16.visibility = View.GONE
            null -> ingredients16?.visibility = View.GONE
            "" -> ingredients16.visibility = View.GONE
            else -> ingredients16.visibility = View.VISIBLE
        }
        when(ingredients17?.text) {
            " " -> ingredients17.visibility = View.GONE
            null -> ingredients17?.visibility = View.GONE
            "" -> ingredients17.visibility = View.GONE
            else -> ingredients17.visibility = View.VISIBLE
        }
        when(ingredients18?.text) {
            " " -> ingredients18.visibility = View.GONE
            null -> ingredients18?.visibility = View.GONE
            "" -> ingredients18.visibility = View.GONE
            else -> ingredients18.visibility = View.VISIBLE
        }
        when(ingredients19?.text) {
            " " -> ingredients19.visibility = View.GONE
            null -> ingredients19?.visibility = View.GONE
            "" -> ingredients19.visibility = View.GONE
            else -> ingredients19.visibility = View.VISIBLE
        }
        when(ingredients20?.text) {
            " " -> ingredients20.visibility = View.GONE
            null -> ingredients20?.visibility = View.GONE
            "" -> ingredients20.visibility = View.GONE
            else -> ingredients20.visibility = View.VISIBLE
        }


        /*
        * Remove TextView when text is null
        * */
        when(ingredients1?.text) {
            " " -> measurement1?.visibility = View.GONE
            null -> measurement1?.visibility = View.GONE
            "" -> measurement1?.visibility = View.GONE
            else -> measurement1?.visibility = View.VISIBLE
        }
        when(ingredients2?.text) {
            " " -> measurement2?.visibility = View.GONE
            null -> measurement2?.visibility = View.GONE
            "" -> measurement2?.visibility = View.GONE
            else -> measurement2?.visibility = View.VISIBLE
        }
        when(ingredients3?.text) {
            " " -> measurement3?.visibility = View.GONE
            null -> measurement3?.visibility = View.GONE
            "" -> measurement3?.visibility = View.GONE
            else -> measurement3?.visibility = View.VISIBLE
        }
        when(ingredients4?.text) {
            " " -> measurement4?.visibility = View.GONE
            null -> measurement4?.visibility = View.GONE
            "" -> measurement4?.visibility = View.GONE
            else -> measurement4?.visibility = View.VISIBLE
        }
        when(ingredients5?.text) {
            " " -> measurement5?.visibility = View.GONE
            null -> measurement5?.visibility = View.GONE
            "" -> measurement5?.visibility = View.GONE
            else -> measurement5?.visibility = View.VISIBLE
        }
        when(ingredients6?.text) {
            " " -> measurement6?.visibility = View.GONE
            null -> measurement6?.visibility = View.GONE
            "" -> measurement6?.visibility = View.GONE
            else -> measurement6?.visibility = View.VISIBLE
        }
        when(ingredients7?.text) {
            " " -> measurement7?.visibility = View.GONE
            null -> measurement7?.visibility = View.GONE
            "" -> measurement7?.visibility = View.GONE
            else -> measurement7?.visibility = View.VISIBLE
        }
        when(ingredients8?.text) {
            " " -> measurement8?.visibility = View.GONE
            null -> measurement8?.visibility = View.GONE
            "" -> measurement8?.visibility = View.GONE
            else -> measurement8?.visibility = View.VISIBLE
        }
        when(ingredients9?.text) {
            " " -> measurement9?.visibility = View.GONE
            null -> measurement9?.visibility = View.GONE
            "" -> measurement9?.visibility = View.GONE
            else -> measurement9?.visibility = View.VISIBLE
        }
        when(ingredients10?.text) {
            " " -> measurement10?.visibility = View.GONE
            null -> measurement10?.visibility = View.GONE
            "" -> measurement10?.visibility = View.GONE
            else -> measurement10?.visibility = View.VISIBLE
        }
        when(ingredients11?.text) {
            " " -> measurement11?.visibility = View.GONE
            null -> measurement11?.visibility = View.GONE
            "" -> measurement11?.visibility = View.GONE
            else -> measurement11?.visibility = View.VISIBLE
        }
        when(ingredients12?.text) {
            " " -> measurement12?.visibility = View.GONE
            null -> measurement12?.visibility = View.GONE
            "" -> measurement12?.visibility = View.GONE
            else -> measurement12?.visibility = View.VISIBLE
        }
        when(ingredients13?.text) {
            " " -> measurement13?.visibility = View.GONE
            null -> measurement13?.visibility = View.GONE
            "" -> measurement13?.visibility = View.GONE
            else -> measurement13?.visibility = View.VISIBLE
        }
        when(ingredients14?.text) {
            " " -> measurement14?.visibility = View.GONE
            null -> measurement14?.visibility = View.GONE
            "" -> measurement14?.visibility = View.GONE
            else -> measurement14?.visibility = View.VISIBLE
        }
        when(ingredients15?.text) {
            " " -> measurement15?.visibility = View.GONE
            null -> measurement15?.visibility = View.GONE
            "" -> measurement15?.visibility = View.GONE
            else -> measurement15?.visibility = View.VISIBLE
        }
        when(ingredients16?.text) {
            " " -> measurement16?.visibility = View.GONE
            null -> measurement16?.visibility = View.GONE
            "" -> measurement16?.visibility = View.GONE
            else -> measurement16?.visibility = View.VISIBLE
        }
        when(ingredients17?.text) {
            " " -> measurement17?.visibility = View.GONE
            null -> measurement17?.visibility = View.GONE
            "" -> measurement17?.visibility = View.GONE
            else -> measurement17?.visibility = View.VISIBLE
        }
        when(ingredients18?.text) {
            " " -> measurement18?.visibility = View.GONE
            null -> measurement18?.visibility = View.GONE
            "" -> measurement18?.visibility = View.GONE
            else -> measurement18?.visibility = View.VISIBLE
        }
        when(ingredients19?.text) {
            " " -> measurement19?.visibility = View.GONE
            null -> measurement19?.visibility = View.GONE
            "" -> measurement19?.visibility = View.GONE
            else -> measurement19?.visibility = View.VISIBLE
        }
        when(ingredients20?.text) {
            " " -> measurement20?.visibility = View.GONE
            null -> measurement20?.visibility = View.GONE
            "" -> measurement20?.visibility = View.GONE
            else -> measurement20?.visibility = View.VISIBLE
        }

        //set the recipe Image to the ImageView in recipe_page.xml
        val thumbnailImageView = img
        Picasso.with(this).load(thumbnailImageView).into(imageView)

    }

}