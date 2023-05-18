package com.example.aplicacionpollossilver.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionpollossilver.Adapter.CartAdapter
import com.example.aplicacionpollossilver.Domain.FoodDomain
import com.example.aplicacionpollossilver.Domain.Product
import com.example.aplicacionpollossilver.Helper.ProductManager
import com.example.aplicacionpollossilver.R
import com.example.aplicacionpollossilver.databinding.ActivityCartListBinding

class CartListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCartListBinding

    //RecyclerView
    private var adapter: RecyclerView.Adapter<*>?=null
    private lateinit var recyclerViewProductsList:RecyclerView
    val productList= ProductManager.productList
    private lateinit var cartAdapter: CartAdapter
    //variables

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityCartListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cartAdapter = CartAdapter(productList, this,this)
        initList()

        binding.cardBtn.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        binding.totalTxt.text="Bs. ${calculateTotal().toString()}"
        binding.BtnRealizarPedido.setOnClickListener {
            Toast.makeText(this,"Se realizo el pedido",Toast.LENGTH_SHORT).show()
            RealizarPedido()
        }
    }
    fun initList(){
        val productList = ProductManager.productList
        if (productList != null) {
            val productListArrayList = ArrayList<Product>(productList)
            val productListMutableList: MutableList<Product> = productListArrayList.toMutableList()
            recyclerViewProductsList = binding.recyclerview
            binding.recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
            adapter = CartAdapter(productListMutableList.toList(),this,this)
            recyclerViewProductsList.adapter=adapter
        }
    }
    fun messageEliminationProduct(){
        Toast.makeText(this,"El producto se elimino",Toast.LENGTH_SHORT).show()
        var intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
    fun calculateTotal(): Double {
        var total = 0.0
        for (product in ProductManager.productList) {
            total += product.fee * product.cantidad
        }
        return total
    }
    fun RealizarPedido(){
        ProductManager.productList.clear()
        var intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}