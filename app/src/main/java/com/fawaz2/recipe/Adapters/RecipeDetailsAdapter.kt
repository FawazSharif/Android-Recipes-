import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.fawaz2.recipe.*
import com.fawaz2.recipe.Models.Meals
import com.fawaz2.recipe.Models.RecipeFeed
import com.fawaz2.recipe.Models.ShoppingList
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso

class RecipeDetailsAdapter (val context: Context, val recipeFeed: RecipeFeed): BaseAdapter(){
    var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    var isSaved = true

    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //To change body of created functions use File | Settings | File Templates.
        var view = convertView
        if(view == null){
            view = layoutInflater.inflate(R.layout.recipe_page, parent,false)
        }

        // To find the textViews and ImageViews in the recipe_page.xml file
        val recipeName = view?.findViewById<TextView>(R.id.mealName)
        val imageView = view?.findViewById<ImageView>(R.id.recipeImage)
        val categoryName = view?.findViewById<TextView>(R.id.category)
        val countryName = view?.findViewById<TextView>(R.id.country)
        val instructions = view?.findViewById<TextView>(R.id.instructions)

        //ingredients
        val ingredients1 = view?.findViewById<CheckBox>(R.id.ingredients1)
        val ingredients2 = view?.findViewById<CheckBox>(R.id.ingredients2)
        val ingredients3 = view?.findViewById<CheckBox>(R.id.ingredients3)
        val ingredients4 = view?.findViewById<CheckBox>(R.id.ingredients4)
        val ingredients5 = view?.findViewById<CheckBox>(R.id.ingredients5)
        val ingredients6 = view?.findViewById<CheckBox>(R.id.ingredients6)
        val ingredients7 = view?.findViewById<CheckBox>(R.id.ingredients7)
        val ingredients8 = view?.findViewById<CheckBox>(R.id.ingredients8)
        val ingredients9 = view?.findViewById<CheckBox>(R.id.ingredients9)
        val ingredients10 = view?.findViewById<CheckBox>(R.id.ingredients10)
        val ingredients11 = view?.findViewById<CheckBox>(R.id.ingredients11)
        val ingredients12 = view?.findViewById<CheckBox>(R.id.ingredients12)
        val ingredients13 = view?.findViewById<CheckBox>(R.id.ingredients13)
        val ingredients14 = view?.findViewById<CheckBox>(R.id.ingredients14)
        val ingredients15 = view?.findViewById<CheckBox>(R.id.ingredients15)
        val ingredients16 = view?.findViewById<CheckBox>(R.id.ingredients16)
        val ingredients17 = view?.findViewById<CheckBox>(R.id.ingredients17)
        val ingredients18 = view?.findViewById<CheckBox>(R.id.ingredients18)
        val ingredients19 = view?.findViewById<CheckBox>(R.id.ingredients19)
        val ingredients20 = view?.findViewById<CheckBox>(R.id.ingredients20)

        //measurements
        val measurement1 = view?.findViewById<TextView>(R.id.measurement1)
        val measurement2 = view?.findViewById<TextView>(R.id.measurement2)
        val measurement3 = view?.findViewById<TextView>(R.id.measurement3)
        val measurement4 = view?.findViewById<TextView>(R.id.measurement4)
        val measurement5 = view?.findViewById<TextView>(R.id.measurement5)
        val measurement6 = view?.findViewById<TextView>(R.id.measurement6)
        val measurement7 = view?.findViewById<TextView>(R.id.measurement7)
        val measurement8 = view?.findViewById<TextView>(R.id.measurement8)
        val measurement9 = view?.findViewById<TextView>(R.id.measurement9)
        val measurement10 = view?.findViewById<TextView>(R.id.measurement10)
        val measurement11 = view?.findViewById<TextView>(R.id.measurement11)
        val measurement12 = view?.findViewById<TextView>(R.id.measurement12)
        val measurement13 = view?.findViewById<TextView>(R.id.measurement13)
        val measurement14 = view?.findViewById<TextView>(R.id.measurement14)
        val measurement15 = view?.findViewById<TextView>(R.id.measurement15)
        val measurement16 = view?.findViewById<TextView>(R.id.measurement16)
        val measurement17 = view?.findViewById<TextView>(R.id.measurement17)
        val measurement18 = view?.findViewById<TextView>(R.id.measurement18)
        val measurement19 = view?.findViewById<TextView>(R.id.measurement19)
        val measurement20 = view?.findViewById<TextView>(R.id.measurement20)

        val youTube = view?.findViewById<FloatingActionButton>(R.id.youtube)
        val source = view?.findViewById<FloatingActionButton>(R.id.source)
        val shareButton = view?.findViewById<FloatingActionButton>(R.id.shareButton)

        //Set the text from Json to these values
        val mealNameText = recipeFeed.meals.get(position).strMeal
        val catNameText = recipeFeed.meals.get(position).strCategory
        val countryNameText = recipeFeed.meals.get(position).strArea
        val instructionsText = recipeFeed.meals.get(position).strInstructions

        val ingredientsText1 = recipeFeed.meals?.get(position).strIngredient1
        val ingredientsText2 = recipeFeed.meals?.get(position).strIngredient2
        val ingredientsText3 = recipeFeed.meals?.get(position).strIngredient3
        val ingredientsText4 = recipeFeed.meals?.get(position).strIngredient4
        val ingredientsText5 = recipeFeed.meals?.get(position).strIngredient5
        val ingredientsText6 = recipeFeed.meals?.get(position).strIngredient6
        val ingredientsText7 = recipeFeed.meals?.get(position).strIngredient7
        val ingredientsText8 = recipeFeed.meals?.get(position).strIngredient8
        val ingredientsText9 = recipeFeed.meals?.get(position).strIngredient9
        val ingredientsText10 = recipeFeed.meals?.get(position).strIngredient10
        val ingredientsText11 = recipeFeed.meals?.get(position).strIngredient11
        val ingredientsText12 = recipeFeed.meals?.get(position).strIngredient12
        val ingredientsText13 = recipeFeed.meals?.get(position).strIngredient13
        val ingredientsText14 = recipeFeed.meals?.get(position).strIngredient14
        val ingredientsText15 = recipeFeed.meals?.get(position).strIngredient15
        val ingredientsText16 = recipeFeed.meals?.get(position).strIngredient16
        val ingredientsText17 = recipeFeed.meals?.get(position).strIngredient17
        val ingredientsText18 = recipeFeed.meals?.get(position).strIngredient18
        val ingredientsText19 = recipeFeed.meals?.get(position).strIngredient19
        val ingredientsText20 = recipeFeed.meals?.get(position).strIngredient20

        val measurementText1 = recipeFeed.meals?.get(position).strMeasure1
        val measurementText2 = recipeFeed.meals?.get(position).strMeasure2
        val measurementText3 = recipeFeed.meals?.get(position).strMeasure3
        val measurementText4 = recipeFeed.meals?.get(position).strMeasure4
        val measurementText5 = recipeFeed.meals?.get(position).strMeasure5
        val measurementText6 = recipeFeed.meals?.get(position).strMeasure6
        val measurementText7 = recipeFeed.meals?.get(position).strMeasure7
        val measurementText8 = recipeFeed.meals?.get(position).strMeasure8
        val measurementText9 = recipeFeed.meals?.get(position).strMeasure9
        val measurementText10 = recipeFeed.meals?.get(position).strMeasure10
        val measurementText11 = recipeFeed.meals?.get(position).strMeasure11
        val measurementText12 = recipeFeed.meals?.get(position).strMeasure12
        val measurementText13 = recipeFeed.meals?.get(position).strMeasure13
        val measurementText14 = recipeFeed.meals?.get(position).strMeasure14
        val measurementText15 = recipeFeed.meals?.get(position).strMeasure15
        val measurementText16 = recipeFeed.meals?.get(position).strMeasure16
        val measurementText17 = recipeFeed.meals?.get(position).strMeasure17
        val measurementText18 = recipeFeed.meals?.get(position).strMeasure18
        val measurementText19 = recipeFeed.meals?.get(position).strMeasure19
        val measurementText20 = recipeFeed.meals?.get(position).strMeasure20

        val youTubeLink = recipeFeed.meals?.get(position).strYoutube
        val sourceLink = recipeFeed.meals.get(position).strSource




        //Open webPage for the source
        source?.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(sourceLink))
            context.startActivity(intent)
        }

        imageView?.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youTubeLink));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setPackage("com.google.android.youtube");
            context.startActivity(intent)

        }

        youTube?.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youTubeLink));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setPackage("com.google.android.youtube");
            context.startActivity(intent)
        }
        shareButton?.setOnClickListener {
            val shareIntent = Intent().apply {
                this.action = Intent.ACTION_SEND
                this.putExtra(
                    Intent.EXTRA_TEXT, "Here's a meal you could try an make at: ${sourceLink}" +
                            "and also watch a vidoe on how to prepare it at: ${youTubeLink}")
                this.type = "text/plain"
            }
            context.startActivity(shareIntent)
        }


        // Here i get the current user
        val currentUser = FirebaseAuth.getInstance().currentUser
        var uid: String? = null
        val firebaseInstance = FirebaseDatabase.getInstance()
        if (currentUser != null){
            uid = currentUser.uid
        }
        /*
        * Here i create a location for each user, where the Meals can be saved.
        */
        val firebasedatabase = firebaseInstance!!
            .getReference("/Users/${uid}").child("Meals")
        firebasedatabase.key

        val postkey = firebasedatabase.key!!
        println("KEYYY" + firebasedatabase)


        val saveBtn = view?.findViewById<com.google.android.material.floatingactionbutton
        .FloatingActionButton>(R.id.saveButton)
        val shareBtn = view?.findViewById<com.google.android.material.floatingactionbutton
        .FloatingActionButton>(R.id.shareButton)

        saveBtn?.setOnClickListener {

            val eventListener: ValueEventListener
            eventListener = object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if(isSaved == true){
                        isSaved = false
                        val strMeal = recipeFeed.meals.get(position).strMeal
                        val strCategory= recipeFeed.meals.get(position).strCategory
                        val strArea = recipeFeed.meals.get(position).strArea
                        val strInstructions = recipeFeed.meals.get(position).strInstructions
                        val idMeal = recipeFeed.meals.get(position).idMeal
                        val strMealThumb = recipeFeed.meals.get(position).strMealThumb
                        val strDrinkAlternate = recipeFeed.meals.get(position).strDrinkAlternate
                        val dateModified =recipeFeed.meals.get(position).dateModified

                        val strIngredient1 = recipeFeed.meals?.get(position).strIngredient1
                        val strIngredient2 = recipeFeed.meals?.get(position).strIngredient2
                        val strIngredient3 = recipeFeed.meals?.get(position).strIngredient3
                        val strIngredient4 = recipeFeed.meals?.get(position).strIngredient4
                        val strIngredient5 = recipeFeed.meals?.get(position).strIngredient5
                        val strIngredient6 = recipeFeed.meals?.get(position).strIngredient6
                        val strIngredient7 = recipeFeed.meals?.get(position).strIngredient7
                        val strIngredient8 = recipeFeed.meals?.get(position).strIngredient8
                        val strIngredient9 = recipeFeed.meals?.get(position).strIngredient9
                        val strIngredient10 = recipeFeed.meals?.get(position).strIngredient10
                        val strIngredient11 = recipeFeed.meals?.get(position).strIngredient11
                        val strIngredient12 = recipeFeed.meals?.get(position).strIngredient12
                        val strIngredient13 = recipeFeed.meals?.get(position).strIngredient13
                        val strIngredient14 = recipeFeed.meals?.get(position).strIngredient14
                        val strIngredient15 = recipeFeed.meals?.get(position).strIngredient15
                        val strIngredient16 = recipeFeed.meals?.get(position).strIngredient16
                        val strIngredient17 = recipeFeed.meals?.get(position).strIngredient17
                        val strIngredient18 = recipeFeed.meals?.get(position).strIngredient18
                        val strIngredient19 = recipeFeed.meals?.get(position).strIngredient19
                        val strIngredient20 = recipeFeed.meals?.get(position).strIngredient20

                        val strMeasure1 = recipeFeed.meals?.get(position).strMeasure1
                        val strMeasure2 = recipeFeed.meals?.get(position).strMeasure2
                        val strMeasure3 = recipeFeed.meals?.get(position).strMeasure3
                        val strMeasure4 = recipeFeed.meals?.get(position).strMeasure4
                        val strMeasure5 = recipeFeed.meals?.get(position).strMeasure5
                        val strMeasure6 = recipeFeed.meals?.get(position).strMeasure6
                        val strMeasure7 = recipeFeed.meals?.get(position).strMeasure7
                        val strMeasure8 = recipeFeed.meals?.get(position).strMeasure8
                        val strMeasure9 = recipeFeed.meals?.get(position).strMeasure9
                        val strMeasure10 = recipeFeed.meals?.get(position).strMeasure10
                        val strMeasure11 = recipeFeed.meals?.get(position).strMeasure11
                        val strMeasure12 = recipeFeed.meals?.get(position).strMeasure12
                        val strMeasure13 = recipeFeed.meals?.get(position).strMeasure13
                        val strMeasure14 = recipeFeed.meals?.get(position).strMeasure14
                        val strMeasure15 = recipeFeed.meals?.get(position).strMeasure15
                        val strMeasure16 = recipeFeed.meals?.get(position).strMeasure16
                        val strMeasure17 = recipeFeed.meals?.get(position).strMeasure17
                        val strMeasure18 = recipeFeed.meals?.get(position).strMeasure18
                        val strMeasure19 = recipeFeed.meals?.get(position).strMeasure19
                        val strMeasure20 = recipeFeed.meals?.get(position).strMeasure20

                        val strYoutube = recipeFeed.meals?.get(position).strYoutube
                        val strSource = recipeFeed.meals.get(position).strSource

                        saveMealsToFireBase( idMeal, strMeal, strDrinkAlternate, strCategory, strArea,
                            strInstructions,  strMealThumb,  strYoutube, strIngredient1, strIngredient2,
                            strIngredient3, strIngredient4, strIngredient5, strIngredient6, strIngredient7, strIngredient8,
                            strIngredient9, strIngredient10, strIngredient11, strIngredient12, strIngredient13,
                            strIngredient14, strIngredient15, strIngredient16, strIngredient17, strIngredient18, strIngredient19,
                            strIngredient20, strMeasure1, strMeasure2, strMeasure3, strMeasure4, strMeasure5, strMeasure6,
                            strMeasure7, strMeasure8, strMeasure9, strMeasure10, strMeasure11, strMeasure12, strMeasure13,
                            strMeasure14, strMeasure15, strMeasure16, strMeasure17, strMeasure18, strMeasure19, strMeasure20,
                            strSource, dateModified)
                        Toast.makeText(context, "Recipe Saved", Toast.LENGTH_SHORT).show()
                    }else if(isSaved == false){
                        saveBtn.visibility = View.VISIBLE

                    }

                }


                override fun onCancelled(databaseError: DatabaseError) {

                }
            }
            firebasedatabase.addListenerForSingleValueEvent(eventListener)
        }

        //set the recipe Image to the ImageView in recipe_page.xml
        val thumbnailImageView = recipeFeed.meals.get(position).strMealThumb
        Picasso.with(view?.context).load(thumbnailImageView).into(imageView)

        //To display the text one each textView on the App
        recipeName?.text = mealNameText
        categoryName?.text = catNameText
        countryName?.text = countryNameText
        instructions?.text = instructionsText

        //set text to Ingredients text view
        ingredients1?.text = ingredientsText1
        ingredients2?.text = ingredientsText2
        ingredients3?.text = ingredientsText3
        ingredients4?.text = ingredientsText4
        ingredients5?.text = ingredientsText5
        ingredients6?.text = ingredientsText6
        ingredients7?.text = ingredientsText7
        ingredients8?.text = ingredientsText8
        ingredients9?.text = ingredientsText9
        ingredients10?.text = ingredientsText10
        ingredients11?.text = ingredientsText11
        ingredients12?.text = ingredientsText12
        ingredients13?.text = ingredientsText13
        ingredients14?.text = ingredientsText14
        ingredients15?.text = ingredientsText15
        ingredients16?.text = ingredientsText16
        ingredients17?.text = ingredientsText17
        ingredients18?.text = ingredientsText18
        ingredients19?.text = ingredientsText19
        ingredients20?.text = ingredientsText20

        //set text to Measurements text view
        measurement1?.text = measurementText1
        measurement2?.text = measurementText2
        measurement3?.text = measurementText3
        measurement4?.text = measurementText4
        measurement5?.text = measurementText5
        measurement6?.text = measurementText6
        measurement7?.text = measurementText7
        measurement8?.text = measurementText8
        measurement9?.text = measurementText9
        measurement10?.text = measurementText10
        measurement11?.text = measurementText11
        measurement12?.text = measurementText12
        measurement13?.text = measurementText13
        measurement14?.text = measurementText14
        measurement15?.text = measurementText15
        measurement16?.text = measurementText16
        measurement17?.text = measurementText17
        measurement18?.text = measurementText18
        measurement19?.text = measurementText19
        measurement20?.text = measurementText20

        //create array list to store each ingredient when checked
        val ingredientsList : MutableList<String> = ArrayList()

        val saveIngredientBtn = view?.findViewById<com.google.android.material.floatingactionbutton.
        FloatingActionButton>(R.id.saveIngredientsBtn)

        //saveIngredientBtn?.visibility = View.GONE
        //onClick listener to save ingredients
        saveIngredientBtn?.setOnClickListener {
            Toast.makeText(context, "Saved to Shopping List", Toast.LENGTH_SHORT).show()

            /*
            * Checking which of the check boxes are checked
            * and saving it to ingredientsList (MutableList)
            * */
            if (ingredients1 != null) {
                if(ingredients1.isChecked){
                    ingredientsList.add(ingredientsText1.toString())
                }else{
                    ingredientsList.add(0, null.toString())
                }
            }
            if (ingredients2 != null) {
                if(ingredients2.isChecked){
                    ingredientsList.add(ingredientsText2.toString())
                }else{
                    ingredientsList.add(1, null.toString())
                }
            }
            if (ingredients3 != null) {
                if(ingredients3.isChecked){
                    ingredientsList.add(ingredientsText3.toString())
                }else{
                    ingredientsList.add(2, null.toString())
                }
            }
            if (ingredients4 != null) {
                if(ingredients4.isChecked){
                    ingredientsList.add(ingredientsText4.toString())
                }else{
                    ingredientsList.add(3, null.toString())
                }
            }
            if (ingredients5 != null) {
                if(ingredients5.isChecked){
                    ingredientsList.add(ingredientsText5.toString())
                }else{
                    ingredientsList.add(4, null.toString())
                }
            }
            if (ingredients6 != null) {
                if(ingredients6.isChecked){
                    ingredientsList.add(ingredientsText6.toString())
                }else{
                    ingredientsList.add(5, null.toString())
                }
            }
            if (ingredients7 != null) {
                if(ingredients7.isChecked){
                    ingredientsList.add(ingredientsText7.toString())
                }else{
                    ingredientsList.add(6, null.toString())
                }
            }
            if (ingredients8 != null) {
                if(ingredients8.isChecked){
                    ingredientsList.add(ingredientsText8.toString())
                }else{
                    ingredientsList.add(7, null.toString())
                }
            }
                if (ingredients9 != null) {
                    if(ingredients9.isChecked){
                        ingredientsList.add(ingredientsText9.toString())
                    }else{
                        ingredientsList.add(8, null.toString())
                    }
                }
                if (ingredients10 != null) {
                    if(ingredients10.isChecked){
                        ingredientsList.add(ingredientsText10.toString())
                    }else{
                        ingredientsList.add(9, null.toString())
                    }
                }
            if (ingredients11 != null) {
                if(ingredients11.isChecked){
                    ingredientsList.add(ingredientsText11.toString())
                }else{
                    ingredientsList.add(10, null.toString())
                }
            }
            if (ingredients12 != null) {
                if(ingredients12.isChecked){
                    ingredientsList.add(ingredientsText12.toString())
                }else{
                    ingredientsList.add(11, null.toString())
                }
            }
            if (ingredients13 != null) {
                if(ingredients13.isChecked){
                    ingredientsList.add(ingredientsText13.toString())
                }else{
                    ingredientsList.add(12, null.toString())
                }
            }
            if (ingredients14 != null) {
                if(ingredients14.isChecked){
                    ingredientsList.add(ingredientsText14.toString())
                }else{
                    ingredientsList.add(13, null.toString())
                }
            }
            if (ingredients15 != null) {
                if(ingredients15.isChecked){
                    ingredientsList.add(ingredientsText15.toString())
                }else{
                    ingredientsList.add(14, null.toString())
                }
            }
            if (ingredients16 != null) {
                if(ingredients16.isChecked){
                    ingredientsList.add(ingredientsText16.toString())
                }else{
                    ingredientsList.add(15, null.toString())
                }
            }
            if (ingredients17 != null) {
                if(ingredients17.isChecked){
                    ingredientsList.add(ingredientsText17.toString())
                }else{
                    ingredientsList.add(16, null.toString())
                }
            }
            if (ingredients18 != null) {
                if(ingredients18.isChecked){
                    ingredientsList.add(ingredientsText18.toString())
                }else{
                    ingredientsList.add(17, null.toString())
                }
            }
            if (ingredients19 != null) {
                if(ingredients19.isChecked){
                    ingredientsList.add(ingredientsText19.toString())
                }else{
                    ingredientsList.add(18, null.toString())
                }
            }
            if (ingredients20 != null) {
                if(ingredients20.isChecked){
                    ingredientsList.add(ingredientsText20.toString())
                }else{
                    ingredientsList.add(19, null.toString())
                }
            }

            //saving users shopping list to firebase
            saveShoppingListToFireBase(ingredientsList.get(0), ingredientsList.get(1), ingredientsList.get(2),
                ingredientsList.get(3), ingredientsList.get(4), ingredientsList.get(5), ingredientsList.get(6),
                ingredientsList.get(7), ingredientsList.get(8), ingredientsList.get(9), ingredientsList.get(10),
                ingredientsList.get(11), ingredientsList.get(12), ingredientsList.get(13), ingredientsList.get(14),
                ingredientsList.get(15), ingredientsList.get(16), ingredientsList.get(17), ingredientsList.get(18),
                ingredientsList.get(19))
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


        return view!!
    }

    // This function will save a user's Meals to firebase
    private fun saveMealsToFireBase(idMeal : Int?,  strMeal : String?, strDrinkAlternate : String?,
                                    strCategory : String?, strArea : String?, strInstructions : String?,
                                    strMealThumb : String?,  strYoutube : String?, strIngredient1 : String?,
                                    strIngredient2 : String?, strIngredient3 : String?, strIngredient4 : String?,
                                    strIngredient5 : String?, strIngredient6: String?, strIngredient7 : String?,
                                    strIngredient8 : String?, strIngredient9 : String?, strIngredient10 : String?,
                                    strIngredient11 : String?, strIngredient12 : String?, strIngredient13 : String?,
                                    strIngredient14 : String?, strIngredient15 : String?, strIngredient16 : String?,
                                    strIngredient17 : String?, strIngredient18 : String?, strIngredient19 : String?,
                                    strIngredient20 : String?, strMeasure1 : String?, strMeasure2 : String?,
                                    strMeasure3 : String?, strMeasure4 : String?, strMeasure5 : String?,
                                    strMeasure6 : String?, strMeasure7 : String?, strMeasure8 : String?,
                                    strMeasure9 : String?, strMeasure10 : String?, strMeasure11: String?,
                                    strMeasure12 : String?, strMeasure13 : String?, strMeasure14 : String?,
                                    strMeasure15 : String?, strMeasure16 : String?, strMeasure17 : String?,
                                    strMeasure18 : String?, strMeasure19 : String?, strMeasure20 : String?,
                                    strSource : String?, dateModified : String?){
        val uid = FirebaseAuth.getInstance().uid?: ""
        val ref = FirebaseDatabase.getInstance().getReference("/Users/${uid}/Meals")
        val updates: MutableMap<String, Meals> = HashMap()

        val meals = Meals(
            idMeal,
            strMeal,
            strDrinkAlternate,
            strCategory,
            strArea,
            strInstructions,
            strMealThumb,
            strYoutube,
            strIngredient1,
            strIngredient2,
            strIngredient3,
            strIngredient4,
            strIngredient5,
            strIngredient6,
            strIngredient7,
            strIngredient8,
            strIngredient9,
            strIngredient10,
            strIngredient11,
            strIngredient12,
            strIngredient13,
            strIngredient14,
            strIngredient15,
            strIngredient16,
            strIngredient17,
            strIngredient18,
            strIngredient19,
            strIngredient20,
            strMeasure1,
            strMeasure2,
            strMeasure3,
            strMeasure4,
            strMeasure5,
            strMeasure6,
            strMeasure7,
            strMeasure8,
            strMeasure9,
            strMeasure10,
            strMeasure11,
            strMeasure12,
            strMeasure13,
            strMeasure14,
            strMeasure15,
            strMeasure16,
            strMeasure17,
            strMeasure18,
            strMeasure19,
            strMeasure20,
            strSource,
            dateModified
        )

        ref.push().setValue(meals)
        println("REF KEYYY::: "+ ref.key)

    }

    // This function will save a user's Meals to firebase
    private fun saveShoppingListToFireBase( strIngredient1 : String?, strIngredient2 : String?,
                                            strIngredient3 : String?, strIngredient4 : String?,
                                            strIngredient5 : String?, strIngredient6: String?,
                                            strIngredient7 : String?, strIngredient8 : String?,
                                            strIngredient9 : String?, strIngredient10 : String?,
                                            strIngredient11 : String?, strIngredient12 : String?,
                                            strIngredient13 : String?, strIngredient14 : String?,
                                            strIngredient15 : String?, strIngredient16 : String?,
                                            strIngredient17 : String?, strIngredient18 : String?,
                                            strIngredient19 : String?, strIngredient20 : String?){
        val uid = FirebaseAuth.getInstance().uid?: ""
        val ref = FirebaseDatabase.getInstance().getReference("/Users/${uid}/Shopping List")
        val updates: MutableMap<String, Meals> = HashMap()

        val shoppingList = ShoppingList(strIngredient1, strIngredient2, strIngredient3, strIngredient4,
            strIngredient5, strIngredient6, strIngredient7, strIngredient8, strIngredient9,
            strIngredient10, strIngredient11, strIngredient12, strIngredient13, strIngredient14,
            strIngredient15, strIngredient16, strIngredient17, strIngredient18, strIngredient19,
            strIngredient20)

        ref.push().setValue(shoppingList)
        println("REF KEYYY::: "+ ref.key)

    }

    override fun getItem(position: Int): Any {
        //To change body of created functions use File | Settings | File Templates.
        return recipeFeed.meals[position]
    }

    override fun getItemId(position: Int): Long {
        //To change body of created functions use File | Settings | File Templates.
        return position.toLong()
    }

    override fun getCount(): Int {
        //To change body of created functions use File | Settings | File Templates.
       return recipeFeed.meals.count()
    }

}