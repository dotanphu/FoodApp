package com.dotanphu.foodapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dotanphu.foodapp.adapter.FoodAdapter
import com.dotanphu.foodapp.databinding.ActivityHomeBinding
import com.dotanphu.foodapp.model.Food
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.R
import android.content.Intent
import android.view.Menu


class HomeActivity : AppCompatActivity() {
    private lateinit var adapter: FoodAdapter
    private lateinit var binding: ActivityHomeBinding

    private var food = arrayListOf<Food>(
        Food(
            "Chicken",
            "https://cdn-icons.flaticon.com/png/512/783/premium/783054.png?token=exp=1640251184~hmac=d4188b81db862ffdcece016bf68abf6a",
            8.6
        ),
        Food(
            "FastFood",
            "https://cdn-icons-png.flaticon.com/512/2922/2922037.png",
            9.6
        ),
        Food(
            "Noodles",
            "https://cdn-icons-png.flaticon.com/512/2718/2718224.png",
            5.6
        ),
        Food(
            "Rice",
            "https://cdn-icons.flaticon.com/png/512/3183/premium/3183463.png?token=exp=1640251184~hmac=b7cd182d6056de286959fed3d58afc19",
            7.6
        ),
        Food(
            "Hamburger",
            "https://cdn-icons.flaticon.com/png/512/566/premium/566651.png?token=exp=1640251184~hmac=c327d8f879b7599eb939a909e47db5c0",
            6.8
        ),
        Food(
            "French fries",
            "https://cdn-icons.flaticon.com/png/512/1744/premium/1744944.png?token=exp=1640251184~hmac=787a4ee91019e65b25d898e45a85dbab",
            6.6
        ),
        Food(
            "Hotdog",
            "https://cdn-icons.flaticon.com/png/512/1789/premium/1789897.png?token=exp=1640251184~hmac=01ad9b4ed4a98b5fbc8027059bc13f3e",
            3.3
        ),
        Food(
            "Drink",
            "https://cdn-icons.flaticon.com/png/512/2769/premium/2769611.png?token=exp=1640251897~hmac=c708d473d186684e1fb523641f4a3721",
            5.8
        ),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = FoodAdapter(food, this)
        binding.rvPopular.adapter = adapter
        binding.rvPopular.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        binding.btnHome.setOnClickListener {
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        binding.btnShopping.setOnClickListener {
            intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }
    }
}