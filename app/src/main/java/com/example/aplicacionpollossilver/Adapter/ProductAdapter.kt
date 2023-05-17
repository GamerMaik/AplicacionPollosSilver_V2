package com.example.aplicacionpollossilver.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionpollossilver.Activity.ShowDetailsActivity
import com.example.aplicacionpollossilver.Domain.FoodDomain
import com.example.aplicacionpollossilver.databinding.ViewholderProductBinding

data class ProductAdapter(private val productList:List<FoodDomain>, private val context:Context):
RecyclerView.Adapter<ProductAdapter.ProductViewHolder>()
{
    inner class ProductViewHolder(private val binding: ViewholderProductBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(product:FoodDomain){
            binding.title.text = product.title
            binding.pic.setImageResource(product.pic)
            binding.fee.text= product.fee.toString()
            itemView.setOnClickListener{
                val intent= Intent(context, ShowDetailsActivity::class.java)
                intent.putExtra("title",product.title)
                intent.putExtra("IdImage",product.pic)
                intent.putExtra("price",product.fee.toString())
                context.startActivity(intent)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding= ViewholderProductBinding.inflate(inflater,parent,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product= productList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int= productList.size
}