package com.fawaz2.recipe.Tutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fawaz2.recipe.Activities.MainActivity
import com.fawaz2.recipe.Adapters.ViewPagerAdapter
import com.fawaz2.recipe.R
import kotlinx.android.synthetic.main.activity_tutorial.*
import me.relex.circleindicator.CircleIndicator3

class TutorialActivity : AppCompatActivity() {

    private var imagesList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        addToList(R.drawable.latest)
        addToList(R.drawable.savetuto)
        addToList(R.drawable.instructions)
        addToList(R.drawable.navdrawer)

        view_pager.adapter = ViewPagerAdapter(imagesList)

        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(view_pager)

        skip.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            this.startActivity(intent)
        }

    }

    private fun addToList(image: Int){
        imagesList.add(image)
        }
}