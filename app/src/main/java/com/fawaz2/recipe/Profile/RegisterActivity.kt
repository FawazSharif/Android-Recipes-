package com.fawaz2.recipe.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.fawaz2.recipe.R
import com.fawaz2.recipe.Models.User
import com.fawaz2.recipe.Tutorial.TutorialActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        // register button listener
        register_button.setOnClickListener {
            registerUser()
            saveUserToFireBase()

        }

        //already have account on click listener
        already_have_account_textView.setOnClickListener {
            Toast.makeText(this, "Login to your account!", Toast.LENGTH_SHORT).show()
            finish()
        }

    }

    fun registerUser(){
        val email = email_editText.text.toString()
        val password = password_editText.text.toString()
        val username  = username_editText.text.toString()

        //get user information from this activity to transfer to other activities.
        val intent = Intent(this, LoginActivity::class.java)
        intent.putExtra("USERNAME", username)

        if(email.isEmpty() || password.isEmpty()|| username.isEmpty()){
            Toast.makeText(this, "Please Enter Email/Password",
                Toast.LENGTH_SHORT).show()
            return
        }

        Log.d("MainActivity", "Email is: " + email)
        Log.d("MainActivity", "Password is: $password")

        //Firebase authentication to create user profile
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (!it.isSuccessful) return@addOnCompleteListener
                //else if successful
                Log.d("Main", "Successfully created user with uid:" +
                        "${it.result?.user?.uid}")
                Toast.makeText(this, "Welcome "+username_editText.text.toString(),
                    Toast.LENGTH_SHORT).show()
                saveUserToFireBase()
                val intent = Intent(this, TutorialActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                this.startActivity(intent)

            }
            .addOnFailureListener {
                Log.d("Main", "Failed to create user: ${it.message}")
                Toast.makeText(this, "Failed to create user:" +
                        " ${it.message}", Toast.LENGTH_SHORT).show()

            }


    }

    // saves a user in the data base
    private fun saveUserToFireBase(){
        val uid = FirebaseAuth.getInstance().uid?: ""
        val ref = FirebaseDatabase.getInstance().getReference("/Users/${uid}")
        val user = User(
            uid, username_editText.text.toString(), email_editText.text.toString()
        )
        ref.setValue(user)
            .addOnSuccessListener {
                Log.d("Main", "User added to DataBase")
                //open activity or the user to select their preferences.
            }

    }


}
