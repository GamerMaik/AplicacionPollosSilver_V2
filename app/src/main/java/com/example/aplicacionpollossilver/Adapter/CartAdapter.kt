package com.example.aplicacionpollossilver.Adapter

import android.content.Context
import android.content.Intent
import android.icu.text.CaseMap.Title
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionpollossilver.Activity.CartListActivity
import com.example.aplicacionpollossilver.Activity.MainActivity
import com.example.aplicacionpollossilver.Domain.Product
import com.example.aplicacionpollossilver.Helper.ProductManager
import com.example.aplicacionpollossilver.databinding.ViewholderCardBinding

data class CartAdapter(private val productList:List<Product>,private val context:Context, private val cartListActivity: CartListActivity):
RecyclerView.Adapter<CartAdapter.CartViewHolder>()
{

    private var numberOrder = 1
    private val maxNumber = 5
    private val minNumber = 1
    inner class CartViewHolder(private val binding: ViewholderCardBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(product:Product){
            val card=CartListActivity()
            binding.CardTitle.text=product.title
            binding.UnitPriceProduct.text=product.fee.toString()
            numberOrder=product.cantidad
            var PrecioUnidad= product.fee
            if (product.cantidad >= 6){
                product.cantidad = 5
                binding.QuantityProductCard.text= product.cantidad.toString()
                binding.TotalPriceCard.text= (PrecioUnidad*numberOrder).toString()
                numberOrder=product.cantidad
            }
            binding.QuantityProductCard.text= product.cantidad.toString()
            binding.picCard.setImageResource(product.pic)
            binding.TotalPriceCard.text= (PrecioUnidad * numberOrder).toString()
            binding.minusCardBtn.setOnClickListener {EliminarProducto(product.title)
                cartListActivity.messageEliminationProduct()
            }
        }

        fun EliminarProducto(title: String){
            ProductManager.productList.removeIf{it.title==title}
        }
        private fun updateNumberText(precioUnidad:Double) {

            binding.QuantityProductCard.text= numberOrder.toString()
            binding.TotalPriceCard.text= (precioUnidad * numberOrder).toString()
        }

        private fun incrementQuantity(precio:Double) {
            if (numberOrder < maxNumber){
                numberOrder++
                updateNumberText(precio)
            }
        }
        private fun decrementQuantity(precio:Double) {
            if (numberOrder > minNumber){
                numberOrder--
                updateNumberText(precio)
            }
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