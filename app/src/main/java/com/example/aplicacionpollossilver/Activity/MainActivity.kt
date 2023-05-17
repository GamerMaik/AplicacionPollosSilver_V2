package com.example.aplicacionpollossilver.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionpollossilver.Adapter.CategoryAdapter
import com.example.aplicacionpollossilver.Adapter.ProductAdapter
import com.example.aplicacionpollossilver.Domain.CategoryDomain
import com.example.aplicacionpollossilver.Domain.FoodDomain
import com.example.aplicacionpollossilver.R
import com.example.aplicacionpollossilver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var adapter: RecyclerView.Adapter<*>?=null
    private var adapter2: RecyclerView.Adapter<*>?=null
    private lateinit var recyclerViewCategoryList:RecyclerView
    private lateinit var recyclerViewProductsList:RecyclerView

    private lateinit var productAdapter: ProductAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerViewCategory()
        recyclerViewProduct()
    }

    private fun recyclerViewCategory() {
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerViewCategoryList= binding.MainRvCategorias
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager)

        val categoryList = ArrayList<CategoryDomain>()
        categoryList.add(CategoryDomain("Pizza", "cat_1"))
        categoryList.add(CategoryDomain("Burger", "cat_2"))
        categoryList.add(CategoryDomain("Hotdog", "cat_3"))
        categoryList.add(CategoryDomain("Drink", "cat_4"))
        categoryList.add(CategoryDomain("Dount", "cat_5"))

        adapter = CategoryAdapter(categoryList)
        recyclerViewCategoryList.adapter = adapter
    }
    private fun recyclerViewProduct(){
        val foodList= listOf(
            FoodDomain("Pizza Vegetarina ",R.drawable.pop_1,18.0),
            FoodDomain("Hamburguesa King ",R.drawable.pop_2,16.0),
            FoodDomain("Pizza Simple ",R.drawable.pop_3,15.0)
        )
        recyclerViewProductsList = binding.MainRvProducts
        binding.MainRvProducts.layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        productAdapter= ProductAdapter(foodList,this)
        recyclerViewProductsList.adapter= productAdapter
    }
}