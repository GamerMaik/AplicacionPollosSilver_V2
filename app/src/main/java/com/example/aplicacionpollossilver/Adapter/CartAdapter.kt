package com.example.aplicacionpollossilver.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionpollossilver.Domain.Product
import com.example.aplicacionpollossilver.databinding.ViewholderCardBinding

data class CartAdapter(private val productList:List<Product>,private val context:Context):
RecyclerView.Adapter<CartAdapter.CartViewHolder>()
{
    inner class CartViewHolder(private val binding: ViewholderCardBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(product:Product){
            binding.CardTitle.text=product.title
            binding.UnitPriceProduct.text=product.fee.toString()
            binding.QuantityProductCard.text= product.cantidad.toString()
            binding.picCard.setImageResource(product.pic)
            var PrecioUnidad= product.fee
            var Cantidad=product.cantidad
            binding.TotalPriceCard.text= (PrecioUnidad*Cantidad).toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding= ViewholderCardBinding.inflate(inflater,parent,false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val product= productList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int= productList.size
}