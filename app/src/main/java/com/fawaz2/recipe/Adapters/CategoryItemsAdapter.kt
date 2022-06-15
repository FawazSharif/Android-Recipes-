package com.fawaz2.recipe.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fawaz2.recipe.Models.CategoryItemsFeed
import com.fawaz2.recipe.Models.Meals
import com.fawaz2.recipe.R
import com.fawaz2.recipe.Pages.RecipeDetailsActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view.view.*


class CategoryItemsAdapter (val categoryItemsFeed: CategoryItemsFeed): RecyclerView.Adapter<CategoryItemsViewHolder>(){

    override fun getItemCount(): Int {
        return categoryItemsFeed.meals.count()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemsViewHolder {

        val layoutInflater = LayoutInflater.from(parent?.context)
        val callForRow = layoutInflater.inflate(R.layout.view,parent,false)
        return CategoryItemsViewHolder(callForRow)
    }

    override fun onBindViewHolder(holder: CategoryItemsViewHolder, position: Int) {
        val meals = categoryItemsFeed.meals.get(position)
        val categorymeal = categoryItemsFeed.meals.get(position)


        holder?.view?.title?.text = meals.strMeal
        val categories = categoryItemsFeed.meals.get(position)
        holder?.view?.title?.text = categories.strMeal

        val thumbnailImageView = holder?.view?.recipeImage
        Picasso.with(holder?.view?.context).load(categories.strMealThumb).into(thumbnailImageView)

        holder?.meals = meals

    }

}

class CategoryItemsViewHolder(val view: View, var meals: Meals? = null): RecyclerView.ViewHolder(view){

    companion object{
        val MEAL_TITLE_KEY = "MEAL_TITLE"
        val MEAL_ID_KEY = "MEAL_ID"
        val CATEGORY_TITLE_KEY = "CATEGORY_TITLE"
        val COUNTRY_KEY = "COUNTRY_NAME"
        val INSRTUCTIONS_KEY = "INSTRUCTIONS"
        val INGREDIENTS_KEY ="INGREDIENTS"
        val MEAL_PIC_KEY = "THUMBNAIL"

    }



    private val ingredients  = "INGREDIENTS: \r\n" + meals?.strIngredient1 + "\r\n" +
            meals?.strIngredient2 + "\r\n" + meals?.strIngredient3 + "\r\n" + meals?.strIngredient4 + "\r\n" +
            meals?.strIngredient5 + "\r\n" + meals?.strIngredient6 + "\r\n"+ meals?.strIngredient7 + "\r\n" +
            meals?.strIngredient8 + "\r\n" + meals?.strIngredient9 + "\r\n" + meals?.strIngredient10 +"\r\n"+
            meals?.strIngredient11 + "\r\n" + meals?.strIngredient12 + "\r\n"+ meals?.strIngredient13 + "\r\n" +
            meals?.strIngredient14 + "\r\n" + meals?.strIngredient15 + "\r\n" + meals?.strIngredient16 + "\r\n" +
            meals?.strIngredient17 + "\r\n" + meals?.strIngredient18 + "\r\n"+ meals?.strIngredient19 + "\r\n" +
            meals?.strIngredient20

    init {
        view.setOnClickListener {
            val intent = Intent(view.context, RecipeDetailsActivity:: class.java)

            intent.putExtra(MEAL_TITLE_KEY,  meals?.strMeal)
            intent.putExtra(MEAL_ID_KEY, meals?.idMeal)
            intent.putExtra(CATEGORY_TITLE_KEY, meals?.strCategory)
            intent.putExtra(COUNTRY_KEY, meals?.strArea)
            intent.putExtra(INSRTUCTIONS_KEY, meals?.strInstructions)
            intent.putExtra(INGREDIENTS_KEY, ingredients)
            intent.putExtra(MEAL_PIC_KEY, meals?.strMealThumb)

            view.context.startActivity(intent)
        }
    }
}
