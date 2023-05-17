package com.example.aplicacionpollossilver.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aplicacionpollossilver.Domain.CategoryDomain
import com.example.aplicacionpollossilver.R
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


class CategoryAdapter(private val categoryDomains: ArrayList<CategoryDomain>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_category, parent, false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categoryDomain = categoryDomains[position]
        holder.categoryName.setText(categoryDomain.getTitle())
        val picUrl: String = when (position) {
            0 -> {
                holder.mainLayout.setBackgroundDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.cat_background))
                "cat_1"
            }
            1 -> {
                holder.mainLayout.setBackgroundDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.cat_background2))
                "cat_2"
            }
            2 -> {
                holder.mainLayout.setBackgroundDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.cat_background2))
                "cat_3"
            }
            3 -> {
                holder.mainLayout.setBackgroundDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.cat_background2))
                "cat_4"
            }
            4 -> {
                holder.mainLayout.setBackgroundDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.cat_background2))
                "cat_5"
            }

            else -> ""
        }
        val drawableResourceId = holder.itemView.context.resources.getIdentifier(picUrl, "drawable", holder.itemView.context.packageName)

        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .into(holder.categoryPic)
    }

    override fun getItemCount(): Int {
        return categoryDomains.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryName: TextView = itemView.findViewById(R.id.categoryName)
        val categoryPic: ImageView = itemView.findViewById(R.id.categoryPic)
        val mainLayout: ConstraintLayout = itemView.findViewById(R.id.mainLayout)
    }
}
