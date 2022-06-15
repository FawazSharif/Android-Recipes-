package com.fawaz2.recipe.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.fawaz2.recipe.Pages.FaveRecipePageActivity
import com.fawaz2.recipe.Models.Meals
import com.fawaz2.recipe.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso


class FavouritesAdapter (val context: Context, val recipeFeed: ArrayList<Meals>): BaseAdapter(){
    var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
            as LayoutInflater

    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //To change body of created functions use File | Settings | File Templates.
        var view = convertView
        if(view == null){
            view = layoutInflater.inflate(R.layout.favourite_view, parent, false)
        }

        // To find the textViews and ImageViews in the recipe_page.xml file
        val mealName = view?.findViewById<TextView>(R.id.title)
        val mealImage = view?.findViewById<ImageView>(R.id.favImage)

        mealName?.text = recipeFeed.get(position).strMeal


        var thumbnailImageView = recipeFeed.get(position).strMealThumb
        /*
        * The API does not always have an image so this will check for image and place a
        * different image in the image view
        * */
        if(thumbnailImageView == ""){
            thumbnailImageView = "https://catholicnewstt.com/wp-content/uploads/2017/05/" +
                    "no-image-available.jpg"
        }
        Picasso.with(view?.context).load(thumbnailImageView).into(mealImage)
        // val newsSiteUrl = articleFeed.get(position).
        val sourceName = recipeFeed.get(position).strSource


        val currentUser = FirebaseAuth.getInstance().currentUser
        var uid: String? = null
        val firebaseInstance = FirebaseDatabase.getInstance()
        if (currentUser != null){
            uid = currentUser.uid
        }
        val firebasedatabase = firebaseInstance!!
            .getReference("/Users/${uid}")
        val postkey = firebasedatabase.key!!

        val postsRef: DatabaseReference = firebasedatabase.child(uid!!)
        val articleID = postsRef.key
        println("HERE AGAIN " + articleID)

        val mealNameText = recipeFeed.get(position).strMeal
        val catNameText = recipeFeed.get(position).strCategory
        val countryNameText = recipeFeed.get(position).strArea
        val instructionsText = recipeFeed.get(position).strInstructions

        val ingredientsText1 = recipeFeed.get(position).strIngredient1
        val ingredientsText2 = recipeFeed.get(position).strIngredient2
        val ingredientsText3 = recipeFeed.get(position).strIngredient3
        val ingredientsText4 = recipeFeed.get(position).strIngredient4
        val ingredientsText5 = recipeFeed.get(position).strIngredient5
        val ingredientsText6 = recipeFeed.get(position).strIngredient6
        val ingredientsText7 = recipeFeed.get(position).strIngredient7
        val ingredientsText8 = recipeFeed.get(position).strIngredient8
        val ingredientsText9 = recipeFeed.get(position).strIngredient9
        val ingredientsText10 = recipeFeed.get(position).strIngredient10
        val ingredientsText11 = recipeFeed.get(position).strIngredient11
        val ingredientsText12 = recipeFeed.get(position).strIngredient12
        val ingredientsText13 = recipeFeed.get(position).strIngredient13
        val ingredientsText14 = recipeFeed.get(position).strIngredient14
        val ingredientsText15 = recipeFeed.get(position).strIngredient15
        val ingredientsText16 = recipeFeed.get(position).strIngredient16
        val ingredientsText17 = recipeFeed.get(position).strIngredient17
        val ingredientsText18 = recipeFeed.get(position).strIngredient18
        val ingredientsText19 = recipeFeed.get(position).strIngredient19
        val ingredientsText20 = recipeFeed.get(position).strIngredient20

        val measurementText1 = recipeFeed.get(position).strMeasure1
        val measurementText2 = recipeFeed.get(position).strMeasure2
        val measurementText3 = recipeFeed.get(position).strMeasure3
        val measurementText4 = recipeFeed.get(position).strMeasure4
        val measurementText5 = recipeFeed.get(position).strMeasure5
        val measurementText6 = recipeFeed.get(position).strMeasure6
        val measurementText7 = recipeFeed.get(position).strMeasure7
        val measurementText8 = recipeFeed.get(position).strMeasure8
        val measurementText9 = recipeFeed.get(position).strMeasure9
        val measurementText10 = recipeFeed.get(position).strMeasure10
        val measurementText11 = recipeFeed.get(position).strMeasure11
        val measurementText12 = recipeFeed.get(position).strMeasure12
        val measurementText13 = recipeFeed.get(position).strMeasure13
        val measurementText14 = recipeFeed.get(position).strMeasure14
        val measurementText15 = recipeFeed.get(position).strMeasure15
        val measurementText16 = recipeFeed.get(position).strMeasure16
        val measurementText17 = recipeFeed.get(position).strMeasure17
        val measurementText18 = recipeFeed.get(position).strMeasure18
        val measurementText19 = recipeFeed.get(position).strMeasure19
        val measurementText20 = recipeFeed.get(position).strMeasure20

        val youTubeLink = recipeFeed.get(position).strYoutube
        val sourceLink = recipeFeed.get(position).strSource

        view!!.setOnClickListener {
            Toast.makeText(view.context, "Loading...", Toast.LENGTH_SHORT).show()
            val intent = Intent(view.context, FaveRecipePageActivity::class.java)


            intent.putExtra("MEAL_NAME", mealNameText)
            intent.putExtra("CATEGORY", catNameText)
            intent.putExtra("COUNTRY", countryNameText)
            intent.putExtra("INSTRUCTIONS", instructionsText)

            intent.putExtra("INGREDIENTS_1", ingredientsText1)
            intent.putExtra("INGREDIENTS_2", ingredientsText2)
            intent.putExtra("INGREDIENTS_3", ingredientsText3)
            intent.putExtra("INGREDIENTS_4", ingredientsText4)
            intent.putExtra("INGREDIENTS_5", ingredientsText5)
            intent.putExtra("INGREDIENTS_6", ingredientsText6)
            intent.putExtra("INGREDIENTS1_7", ingredientsText7)
            intent.putExtra("INGREDIENTS_8", ingredientsText8)
            intent.putExtra("INGREDIENTS_9", ingredientsText9)
            intent.putExtra("INGREDIENTS_10", ingredientsText10)
            intent.putExtra("INGREDIENTS_11", ingredientsText11)
            intent.putExtra("INGREDIENTS_12", ingredientsText12)
            intent.putExtra("INGREDIENTS_13", ingredientsText13)
            intent.putExtra("INGREDIENTS_14", ingredientsText14)
            intent.putExtra("INGREDIENTS_15", ingredientsText15)
            intent.putExtra("INGREDIENTS_16", ingredientsText16)
            intent.putExtra("INGREDIENTS_17", ingredientsText17)
            intent.putExtra("INGREDIENTS_18", ingredientsText18)
            intent.putExtra("INGREDIENTS_19", ingredientsText19)
            intent.putExtra("INGREDIENTS_20", ingredientsText20)

            intent.putExtra("MEASUREMENT_1", measurementText1)
            intent.putExtra("MEASUREMENT_2", measurementText2)
            intent.putExtra("MEASUREMENT_3", measurementText3)
            intent.putExtra("MEASUREMENT_4", measurementText4)
            intent.putExtra("MEASUREMENT_5", measurementText5)
            intent.putExtra("MEASUREMENT_6", measurementText6)
            intent.putExtra("MEASUREMENT_7", measurementText7)
            intent.putExtra("MEASUREMENT_8", measurementText8)
            intent.putExtra("MEASUREMENT_9", measurementText9)
            intent.putExtra("MEASUREMENT_10", measurementText10)
            intent.putExtra("MEASUREMENT_11", measurementText11)
            intent.putExtra("MEASUREMENT_12", measurementText12)
            intent.putExtra("MEASUREMENT_13", measurementText13)
            intent.putExtra("MEASUREMENT_14", measurementText14)
            intent.putExtra("MEASUREMENT_15", measurementText15)
            intent.putExtra("MEASUREMENT_16", measurementText16)
            intent.putExtra("MEASUREMENT_17", measurementText17)
            intent.putExtra("MEASUREMENT_18", measurementText18)
            intent.putExtra("MEASUREMENT_19", measurementText19)
            intent.putExtra("MEASUREMENT_20", measurementText20)

            intent.putExtra("SOURCE", sourceLink)
            intent.putExtra("YOUTUBE", youTubeLink)

            intent.putExtra("IMAGE", thumbnailImageView)



            view.context.startActivity(intent)

        }

        return view!!
    }

    override fun getItem(position: Int): Any {
        //To change body of created functions use File | Settings | File Templates.
        return recipeFeed.get(position)
    }

    override fun getItemId(position: Int): Long {
        //To change body of created functions use File | Settings | File Templates.
        return position.toLong()
    }

    override fun getCount(): Int {
        //To change body of created functions use File | Settings | File Templates.
        return recipeFeed.count()
    }

}