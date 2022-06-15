package com.fawaz2.recipe.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.fawaz2.recipe.Models.RecipeFeed
import com.fawaz2.recipe.Pages.SearchedMealPage
import com.fawaz2.recipe.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.all_recipe_content_main.view.*
import kotlinx.android.synthetic.main.view.view.*

/*
* Adapter class to populate the textViews and imagesView With data.
* */
class SearchAdapter (val context: Context, val recipeFeed: RecipeFeed): BaseAdapter(){


    var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
            as LayoutInflater

    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //To change body of created functions use File | Settings | File Templates.
        var view = convertView
        if(view == null){
            view = layoutInflater.inflate(R.layout.view, parent,false)
        }

        val meals = recipeFeed.meals.get(position)
        view?.latestItemsName?.text = meals.strMeal
        view?.title?.text = meals.strMeal

        val mealID  = recipeFeed.meals.get(position).idMeal

        val thumbnailImageView = view?.recipeImage
        Picasso.with(view?.context).load(meals.strMealThumb).into(thumbnailImageView)

        view?.setOnClickListener{
            val intent = Intent(context, SearchedMealPage::class.java)
            intent.putExtra("MEAL_ID_KEY", mealID )

            context.startActivity(intent)
        }

        return view!!
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