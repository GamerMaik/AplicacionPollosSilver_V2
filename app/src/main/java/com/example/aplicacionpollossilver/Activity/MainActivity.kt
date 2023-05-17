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
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerViewProductsList=binding.MainRvProducts
        recyclerViewProductsList.setLayoutManager(linearLayoutManager)

        val foodList= ArrayList<FoodDomain>()
        foodList.add(FoodDomain("Pepperoni pizza", "pop_1", "slices pepperoni ,mozzarella cheese, fresh oregano,  ground black pepper, pizza sauce", 9.76,0))
        foodList.add(FoodDomain("Cheese Burger", "pop_2", "beef, Gouda Cheese, Special sauce, Lettuce, tomato ", 8.79,1))
        foodList.add(FoodDomain("Vegetable pizza", "pop_3", " olive oil, Vegetable oil, pitted Kalamata, cherry tomatoes, fresh oregano, basil", 8.5,2))
        foodList.add(FoodDomain("Pepperoni pizza", "pop_1", "slices pepperoni ,mozzarella cheese, fresh oregano,  ground black pepper, pizza sauce", 9.76,3))
        foodList.add(FoodDomain("Cheese Burger", "pop_2", "beef, Gouda Cheese, Special sauce, Lettuce, tomato ", 8.79,4))
        foodList.add(FoodDomain("Vegetable pizza", "pop_3", " olive oil, Vegetable oil, pitted Kalamata, cherry tomatoes, fresh oregano, basil", 8.5,5))

        adapter2 = ProductAdapter(foodList)
        recyclerViewProductsList.adapter= adapter2
    }
}