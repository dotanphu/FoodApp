package com.dotanphu.foodapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dotanphu.foodapp.databinding.ActivityHomeBinding
import com.dotanphu.foodapp.model.Food

class HomeActivity : AppCompatActivity() {
    private lateinit var adapter: FoodAdapter
    private lateinit var binding: ActivityHomeBinding
    private var food = arrayListOf<Food>(
        Food("Hamburger", "hamburger", 8.7),
        Food("FastFood", "fastfood", 8.7)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = FoodAdapter(food)
        binding.rvPopular.adapter = adapter
        binding.rvPopular.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }
}