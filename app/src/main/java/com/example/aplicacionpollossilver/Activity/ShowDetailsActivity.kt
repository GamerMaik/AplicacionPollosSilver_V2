package com.example.aplicacionpollossilver.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.aplicacionpollossilver.Domain.FoodDomain
import com.example.aplicacionpollossilver.Domain.Product
import com.example.aplicacionpollossilver.Helper.ProductManager
import com.example.aplicacionpollossilver.databinding.ActivityShowDetailsBinding

class ShowDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowDetailsBinding
    //Variables
    private var numberOrder = 1
    private val maxNumber = 5
    private val minNumber = 1
    //Tools
    val productList: MutableList<Product> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityShowDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var title: String? = intent.getStringExtra("title")
        var price: String? = intent.getStringExtra("price")
        var image: Int = intent.getIntExtra("IdImage",0)
        var description:String?= intent.getStringExtra("description")
        updateNumberText()
        getProductInfo(title, price, image, description)
        if (title != null && price != null && description != null) {
            setupListeners(title, price, image, numberOrder, description)
        }
    }
    private fun setupListeners(title:String, price:String, image:Int, cantidad: Int, descriptionText: String) {
        binding.plusBtn.setOnClickListener { incrementQuantity() }
        binding.minusBtn.setOnClickListener { decrementQuantity() }
        binding.addToCardBtn.setOnClickListener { addToList(price, image) }
    }

    private fun addToList(price: String, image: Int) {
        val title = binding.titleTxt.text.toString()
        val quantity = binding.numberOrderTxt.text.toString().toInt()
        val description = binding.descriptionTxt.text.toString()
        val newProduct = Product(title, image, price.toDouble(), quantity, description)
        val existingProduct = ProductManager.productList.find { it.title == title }
        if (existingProduct != null) {
            existingProduct.cantidad += quantity
        } else {
            ProductManager.productList.add(newProduct)
        }
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    private fun updateNumberText() {
        binding.numberOrderTxt.text= numberOrder.toString()
    }

    private fun incrementQuantity() {
        if (numberOrder < maxNumber){
            numberOrder++
            updateNumberText()
        }
    }
    private fun decrementQuantity() {
        if (numberOrder > minNumber){
            numberOrder--
            updateNumberText()
        }
    }
    private fun getProductInfo(title:String?, price:String?, image:Int, descriptionText:String?) {

        binding.titleTxt.text = title
        binding.priceTxt.text = "Bs. $price"
        binding.foodPic.setImageResource(image)
        binding.descriptionTxt.text = descriptionText

    }

}