package com.example.aplicacionpollossilver.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aplicacionpollossilver.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BtnEmpezar.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java).apply {

                //Se envia o se comprueba lo que sea antes de pasar la siguiente pantalla

            }
            startActivity(intent)
        }
    }
}