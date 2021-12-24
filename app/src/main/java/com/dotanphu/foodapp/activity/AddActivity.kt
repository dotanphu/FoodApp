package com.dotanphu.foodapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dotanphu.foodapp.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCheckOut.setOnClickListener {
            intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        binding.imgShoppingCart.setOnClickListener {
            intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }
    }
}