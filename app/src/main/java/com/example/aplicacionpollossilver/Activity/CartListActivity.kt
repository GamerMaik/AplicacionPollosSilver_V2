package com.example.aplicacionpollossilver.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.ScrollView
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCartListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initList()
    }
    fun initList(){
        val productList = ProductManager.productList
        if (productList != null) {
            val productListArrayList = ArrayList<Product>(productList)
            val productListMutableList: MutableList<Product> = productListArrayList.toMutableList()
            recyclerViewProductsList = binding.recyclerview
            binding.recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
            adapter = CartAdapter(productListMutableList.toList(),this)
            recyclerViewProductsList.adapter=adapter
        }
    }
}