package com.example.aplicacionpollossilver.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.aplicacionpollossilver.Domain.FoodDomain
import com.example.aplicacionpollossilver.databinding.ActivityShowDetailsBinding

class ShowDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowDetailsBinding
    //Texts
    private lateinit var addToCardBtn:TextView
    private lateinit var title: TextView
    private lateinit var feeText:TextView
    private lateinit var descriptionText:TextView
    private lateinit var numberOrderTxt:TextView
    //buttons
    private lateinit var plusBtn: ImageView
    private lateinit var minusBtn: ImageView
    private lateinit var picFood: ImageView
    //Domain
    private lateinit var objecto:FoodDomain
    //Variables
    private var numberOrder:Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityShowDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        numberOrder = 1
        getBunddle()
    }

    private fun getBunddle() {
        val title = intent.getStringExtra("title")
        val price = intent.getStringExtra("price")
        val image= intent.getIntExtra("IdImage",0)
        binding.titleTxt.text = title
        binding.priceTxt.text = "Bs. $price"
        binding.foodPic.setImageResource(image)
        binding.addToCardBtn.setOnClickListener {
        }

    }
}