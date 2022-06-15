package com.fawaz2.recipe.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fawaz2.recipe.R
import com.fawaz2.recipe.Search.MealsByIngredients
import com.fawaz2.recipe.Search.SearchedMealActivity
import kotlinx.android.synthetic.main.ingredients_view.view.*

class SelectIngredientsAdapter  (var ingredientsFeed: Array<String>): RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return ingredientsFeed.count()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val callForRow = layoutInflater.inflate(R.layout.ingredients_view,parent,false)
        return ViewHolder(callForRow)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.view?.ingredientName?.text = ingredientsFeed.get(position)
    }


}

class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
    companion object{
        val INGREDIENT_TITLE_KEY = "INGREDIENT_TITLE"
        val MEAL_NAME_KEY = "MEAL_NAME"

    }

    init {
        view.setOnClickListener {
            val name = view.findViewById<TextView>(R.id.ingredientName)
            val intent = Intent(view.context, MealsByIngredients:: class.java)
            intent.putExtra(INGREDIENT_TITLE_KEY, name.text)

            val intent2 = Intent(view.context, SearchedMealActivity:: class.java)
            intent2.putExtra(MEAL_NAME_KEY, name.text)

            view.context.startActivity(intent)

        }

    }

}