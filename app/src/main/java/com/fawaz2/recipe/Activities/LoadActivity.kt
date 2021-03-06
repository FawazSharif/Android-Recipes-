package com.fawaz2.recipe.Activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.fawaz2.recipe.Profile.LoginActivity
import com.fawaz2.recipe.R
import com.google.firebase.auth.FirebaseAuth

class LoadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)

        supportActionBar?.hide()
        val activity: Activity




        Handler().postDelayed({
            verifyUserIsLoggedIn()
            finish()
        },3000)


    }

    //Checks if a user is logged in and sends them to the register activity if no one is logged in
    private fun verifyUserIsLoggedIn(){
        val uid = FirebaseAuth.getInstance().uid
        if(uid == null){
            Log.d("null user", "Userid: "+uid)
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            Log.d("intent","Intent is working ")
        }else{
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }
}
