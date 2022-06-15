package com.fawaz2.recipe.Profile

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fawaz2.recipe.R
import com.fawaz2.recipe.Models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        /*
        getting the reference of the user from the firebase database, to access
        the users information
        */


        var uid: String? = null
        val firebaseInstance = FirebaseDatabase.getInstance()
        val firebasedatabase = firebaseInstance!!.getReference("/Users")
        firebasedatabase.keepSynced(true)

        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null){
            uid = currentUser.uid
        }
        //User data change Listener
        firebasedatabase!!.child(uid!!).addValueEventListener(object: ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(User::class.java)
                //check if user is null
                if (user == null){
                    Log.d("user null check", "user data is null")
                    return
                }
                userNameText.text = user.username
                emailText.text = user.email

            }
            override fun onCancelled(error: DatabaseError) {

            }
        })

        // sign out of profile button listener
        signOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)

        }


    }

}
