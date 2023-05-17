package com.example.aplicacionpollossilver.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionpollossilver.Adapter.CategoryAdapter
import com.example.aplicacionpollossilver.Domain.CategoryDomain
import com.example.aplicacionpollossilver.R
import com.example.aplicacionpollossilver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var adapter: RecyclerView.Adapter<*>?=null
    private lateinit var recyclerViewCategoryList:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerViewCategory()
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
}