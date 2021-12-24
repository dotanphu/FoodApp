package com.dotanphu.foodapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dotanphu.foodapp.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}