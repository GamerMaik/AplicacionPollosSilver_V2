package com.example.aplicacionpollossilver.Activity

import android.content.Intent
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

    //Variables
    private var foodOrDrink=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerViewCategory()
        recyclerViewProduct()

        binding.ListaBtn.setOnClickListener {
            val intent= Intent(this, CartListActivity::class.java)
            startActivity(intent)
        }

    }
    private fun recyclerViewCategory() {
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerViewCategoryList= binding.MainRvCategorias
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager)

        val categoryList = ArrayList<CategoryDomain>()
        categoryList.add(CategoryDomain("Pollos", "cat_1"))
        categoryList.add(CategoryDomain("Bebidas", "cat_4"))
        adapter = CategoryAdapter(categoryList)
        recyclerViewCategoryList.adapter = adapter
    }
    private fun recyclerViewProduct(){
            val foodList= listOf(
                FoodDomain("ALA Y PECHO",R.drawable.pop_1,18.0,0,""),
                FoodDomain("PECHO",R.drawable.pop_2,18.0,0,""),
                FoodDomain("PIERNA Y ENTREPIERNA ",R.drawable.pop_3,18.0,0,""),
                FoodDomain("COCA COLA ",R.drawable.pop_4,12.0,0,""),
                FoodDomain("FANTA PAPAYA ",R.drawable.pop_5,7.0,0,""),
                FoodDomain("SPRITE ",R.drawable.pop_6,3.0,0,"")
            )
            recyclerViewProductsList = binding.MainRvProducts
            binding.MainRvProducts.layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
            productAdapter= ProductAdapter(foodList,this)
            recyclerViewProductsList.adapter= productAdapter
    }
}