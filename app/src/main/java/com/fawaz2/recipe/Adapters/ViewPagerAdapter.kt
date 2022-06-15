package com.fawaz2.recipe.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.fawaz2.recipe.R

class ViewPagerAdapter (private var images: List<Int>) :
    RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {

    inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tutorialImage : ImageView = itemView.findViewById(R.id.tutorialImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapter.PagerViewHolder {
       return PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.tutorial_page,parent, false))

    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.PagerViewHolder, position: Int) {
        holder.tutorialImage.setImageResource(images[position])
    }
}