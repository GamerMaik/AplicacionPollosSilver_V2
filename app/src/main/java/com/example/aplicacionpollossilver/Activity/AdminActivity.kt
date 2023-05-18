package com.example.aplicacionpollossilver.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionpollossilver.Adapter.CartAdapter
import com.example.aplicacionpollossilver.Adapter.PedidosAdapter
import com.example.aplicacionpollossilver.Adapter.ProductAdapter
import com.example.aplicacionpollossilver.Domain.FoodDomain
import com.example.aplicacionpollossilver.Domain.PedidosDomain
import com.example.aplicacionpollossilver.Domain.Product
import com.example.aplicacionpollossilver.Helper.PedidosManager
import com.example.aplicacionpollossilver.Helper.ProductManager
import com.example.aplicacionpollossilver.R
import com.example.aplicacionpollossilver.databinding.ActivityAdminBinding

class AdminActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdminBinding

    private lateinit var recyclerViewProductsList: RecyclerView
    private lateinit var recyclerViewPedidosList: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private lateinit var pedidosAdapter: PedidosAdapter
    private var adapter: RecyclerView.Adapter<*>? = null
    private lateinit var cartAdapter: CartAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerViewProduct()
        val existingProduct = PedidosManager.productList.find { it.title == title }
        if (existingProduct != null) {
            Toast.makeText(this, "g", Toast.LENGTH_SHORT).show()
        } else {
            initList()
        }
    }

    private fun recyclerViewProduct() {
        val foodList = listOf(
            FoodDomain("ALA Y PECHO", R.drawable.pop_1, 18.0, 0, ""),
            FoodDomain("PECHO", R.drawable.pop_2, 18.0, 0, ""),
            FoodDomain("PIERNA Y ENTREPIERNA ", R.drawable.pop_3, 18.0, 0, ""),
            FoodDomain("COCA COLA ", R.drawable.pop_4, 12.0, 0, ""),
            FoodDomain("FANTA PAPAYA ", R.drawable.pop_5, 7.0, 0, ""),
            FoodDomain("SPRITE ", R.drawable.pop_6, 3.0, 0, "")
        )
        recyclerViewProductsList = binding.MainRvCategorias
        binding.MainRvCategorias.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        productAdapter = ProductAdapter(foodList, this)
        recyclerViewProductsList.adapter = productAdapter
    }

    fun initList() {
        var p1 = PedidosDomain("Pedido1", 2, "PROCESO")
        var p2 = PedidosDomain("Pedido1", 1, "PROCESO")

        val productlist = PedidosManager.productList
        recyclerViewPedidosList = binding.MainRvProducts
        binding.MainRvProducts.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        PedidosManager.productList.add(p1)
        PedidosManager.productList.add(p2)
        pedidosAdapter = PedidosAdapter(productlist, this, this)
        recyclerViewPedidosList.adapter = pedidosAdapter

    }

    fun EntregarPedido() {

    }

}