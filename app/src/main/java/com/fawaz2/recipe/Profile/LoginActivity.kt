package com.fawaz2.recipe.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.fawaz2.recipe.Activities.MainActivity
import com.fawaz2.recipe.Models.Meals
import com.fawaz2.recipe.R
import com.fawaz2.recipe.Models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val intent: Intent = getIntent()

        // register button listener
        login_button.setOnClickListener {
            val email = login_email_editText.text.toString()
            val password = login_password_editText.text.toString()

            if(TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Email and password cannot be null",
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Email and password cannot be null",
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Log.d("MainActivity", "Attempting to login with Email?password")

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                .addOnCompleteListener{
                    if(!it.isSuccessful) return@addOnCompleteListener
                    Log.d("Main", "Successfully signed in")
                   // saveUserToFireBase()
                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                    this.startActivity(intent)

                }
                .addOnFailureListener {
                    Log.d("Main", "Failed to sign in")
                    Toast.makeText(this, "Failed to sign in:" +
                            " ${it.message}", Toast.LENGTH_SHORT).show()

                }


        }


        //already have account on click listener
        create_account_textView.setOnClickListener {
            Toast.makeText(this, "Create an account!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, RegisterActivity::class.java)
            this.startActivity(intent)
        }



    }

    // saves a user in the data base
    private fun saveUserToFireBase(){
        val uid = FirebaseAuth.getInstance().uid?: ""
        val ref = FirebaseDatabase.getInstance().getReference("/Users/${uid}")
        val idMeal = 0
        val strMeal = ""
        val strDrinkAlternate = ""
        val strCategory = ""
        val strArea = ""
        val strInstructions = ""
        val strMealThumb =""
        val strYoutube = ""
        val strIngredient1 = ""
        val  strIngredient2 = ""
        val  strIngredient3 = ""
        val  strIngredient4 = ""
        val  strIngredient5 = ""
        val  strIngredient6 = ""
        val  strIngredient7 = ""
        val  strIngredient8 = ""
        val  strIngredient9 = ""
        val  strIngredient10 = ""
        val  strIngredient11 = ""
        val  strIngredient12 = ""
        val  strIngredient13 = ""
        val  strIngredient14 = ""
        val  strIngredient15 = ""
        val  strIngredient16 = ""
        val  strIngredient17 = ""
        val  strIngredient18 = ""
        val  strIngredient19 = ""
        val  strIngredient20 = ""
        val strMeasure1 = ""
        val strMeasure2 = ""
        val strMeasure3 = ""
        val strMeasure4 = ""
        val strMeasure5 = ""
        val strMeasure6 = ""
        val strMeasure7 = ""
        val strMeasure8 = ""
        val strMeasure9 = ""
        val strMeasure10 = ""
        val strMeasure11 = ""
        val strMeasure12 = ""
        val strMeasure13 = ""
        val strMeasure14 = ""
        val strMeasure15 = ""
        val strMeasure16 = ""
        val strMeasure17 = ""
        val strMeasure18 = ""
        val strMeasure19 = ""
        val strMeasure20 = ""
        val strSource = ""
        val dateModified = ""

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
        //val articleFeed =""//ArticleFeed(listOf(articles))
        val user = User(
            uid, username_editText.text.toString(), email_editText.text.toString()
        )
        ref.setValue(user)
            .addOnSuccessListener {
                Log.d("Main", "User added to DataBase")
            }
        // ref.setValue(articleFeed)

    }

    //Checks if a user is logged in and sends them to the register activity if no one is logged in
    private fun verifyUserIsLoggedIn(){
        val uid = FirebaseAuth.getInstance().uid
        if(uid != null){
            Log.d("null user", "Userid: "+uid)
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            Log.d("intent","Intent is working ")
        }
    }
}
