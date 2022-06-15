package com.fawaz2.recipe.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fawaz2.recipe.R
import com.fawaz2.recipe.Search.SearchedMealActivity
import kotlinx.android.synthetic.main.ingredients_view.view.*

class SelectedMealAdapter  (var mealNameFeed: Array<String>): RecyclerView.Adapter<MealViewHolder>() {

    override fun getItemCount(): Int {
        return mealNameFeed.count()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val callForRow = layoutInflater.inflate(R.layout.ingredients_view,parent,false)
        return MealViewHolder(callForRow)
    }


    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder?.view?.ingredientName?.text = mealNameFeed.get(position)
    }


}

class MealViewHolder(val view: View): RecyclerView.ViewHolder(view){
    companion object{

        val MEAL_NAME_KEY = "MEAL_NAME"

    }

    init {
        view.setOnClickListener {
            val name = view.findViewById<TextView>(R.id.ingredientName)
            val intent = Intent(view.context, SearchedMealActivity:: class.java)
            intent.putExtra("MEAL", name.text)

            view.context.startActivity(intent)

        }

    }

}