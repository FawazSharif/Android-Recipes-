package com.fawaz2.recipe.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fawaz2.recipe.Models.Meals
import com.fawaz2.recipe.R
import com.fawaz2.recipe.Pages.RecipeDetailsActivity
import com.fawaz2.recipe.Models.RecipeFeed
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.all_recipe_content_main.view.*
import kotlinx.android.synthetic.main.view.view.*

class LatestRecipeAdapter(val recipeFeed: RecipeFeed) :
    RecyclerView.Adapter<LatestRecipeViewHolder>() {

    override fun getItemCount(): Int {
        return recipeFeed.meals.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestRecipeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val callForRow = layoutInflater.inflate(R.layout.view, parent, false)
        return LatestRecipeViewHolder(callForRow)
    }

    override fun onBindViewHolder(holder: LatestRecipeViewHolder, position: Int) {
        val meals = recipeFeed.meals.get(position)
        holder.view.latestItemsName?.text = meals.strMeal
        holder.view.title?.text = meals.strMeal

        val thumbnailImageView = holder.view.recipeImage
        Picasso.with(holder.view.context).load(meals.strMealThumb).into(thumbnailImageView)

        holder.meals = meals
    }
}


class LatestRecipeViewHolder(val view: View, var meals: Meals? = null) :
    RecyclerView.ViewHolder(view) {

    companion object {
        val MEAL_TITLE_KEY = "MEAL_TITLE"
        val MEAL_ID_KEY = "MEAL_ID"

    }

    // Opens the recipe details page when a recipe is clicked
    init {
        view.setOnClickListener {
            val intent = Intent(view.context, RecipeDetailsActivity::class.java)
            intent.putExtra(MEAL_TITLE_KEY, meals?.strMeal)
            intent.putExtra(MEAL_ID_KEY, meals?.idMeal)

            view.context.startActivity(intent)
        }
    }


}