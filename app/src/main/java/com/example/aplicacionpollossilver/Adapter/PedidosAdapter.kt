package com.example.aplicacionpollossilver.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionpollossilver.Activity.AdminActivity
import com.example.aplicacionpollossilver.Activity.CartListActivity
import com.example.aplicacionpollossilver.Activity.ShowDetailsActivity
import com.example.aplicacionpollossilver.Domain.FoodDomain
import com.example.aplicacionpollossilver.Domain.PedidosDomain
import com.example.aplicacionpollossilver.Helper.PedidosManager
import com.example.aplicacionpollossilver.Helper.ProductManager
import com.example.aplicacionpollossilver.databinding.ViewholderPedidosBinding
import com.example.aplicacionpollossilver.databinding.ViewholderProductBinding

data class PedidosAdapter(
    private val productList: List<PedidosDomain>,
    private val context: Context,
    private val adminActivity: AdminActivity
) :
    RecyclerView.Adapter<PedidosAdapter.ProductViewHolder>() {
    inner class ProductViewHolder(private val binding: ViewholderPedidosBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: PedidosDomain) {
            binding.CardTitle.text = product.title
            binding.QuantityProductCard.text = product.cantidad.toString()
            binding.EstatusOrder.text = product.description
            binding.minusCardBtn.setOnClickListener {
                CancelarPedido(product.title)
            }
        }
        fun CancelarPedido(title: String) {
            PedidosManager.productList.removeIf { it.title == title }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewholderPedidosBinding.inflate(inflater, parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = productList.size
}