package com.example.aplicacionpollossilver.Adapter

import android.content.Intent
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
import com.example.aplicacionpollossilver.Domain.FoodDomain


class ProductAdapter(private val productDomain: ArrayList<FoodDomain>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.viewholder_product, parent, false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodDomain = productDomain[position]
        holder.title.text = foodDomain.title
        holder.fee.text = foodDomain.fee.toString()

        val drawableResourceId = holder.itemView.context.resources.getIdentifier(
            foodDomain.pic,
            "drawable",
            holder.itemView.context.packageName
        )

        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .into(holder.pic)

        holder.addBtn.setOnClickListener {
//            val intent = Intent(holder.itemView.context, ShowDetailActivity::class.java)
//            intent.putExtra("object", foodDomain)
//            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return productDomain.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val fee: TextView = itemView.findViewById(R.id.fee)
        val pic: ImageView = itemView.findViewById(R.id.pic)
        val addBtn: TextView = itemView.findViewById(R.id.addBtn)
    }
}
