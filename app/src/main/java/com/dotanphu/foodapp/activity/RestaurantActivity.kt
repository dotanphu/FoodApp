package com.dotanphu.foodapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dotanphu.foodapp.databinding.ActivityRestaurantBinding

class RestaurantActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRestaurantBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}