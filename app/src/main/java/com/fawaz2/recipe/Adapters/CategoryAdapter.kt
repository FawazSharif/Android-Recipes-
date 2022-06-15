package com.fawaz2.recipe.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fawaz2.recipe.Models.Categories
import com.fawaz2.recipe.Models.CategoryFeed
import com.fawaz2.recipe.Activities.CategoryItemsActivity
import com.fawaz2.recipe.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view.view.*

class CategoryAdapter(val categoryFeed: CategoryFeed): RecyclerView.Adapter<CustomViewHolder>(){
    override fun getItemCount(): Int {
        return categoryFeed.categories.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val callForRow = layoutInflater.inflate(R.layout.view,parent,false)
        return CustomViewHolder(callForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val categories = categoryFeed.categories.get(position)
        holder?.view?.title?.text = categories.strCategory

        val thumbnailImageView = holder?.view?.recipeImage
        Picasso.with(holder?.view?.context).load(categories.strCategoryThumb).into(thumbnailImageView)

        holder?.categories = categories

    }

}

class CustomViewHolder(val view: View, var categories: Categories? = null): RecyclerView.ViewHolder(view){
    companion object{
        val CATEGORY_TITLE_KEY = "CATEGORY_TITLE"

    }

    init {
        view.setOnClickListener {
            val intent = Intent(view.context, CategoryItemsActivity:: class.java)
            intent.putExtra(CATEGORY_TITLE_KEY , categories?.strCategory)
            
            view.context.startActivity(intent)

        }
    }

}