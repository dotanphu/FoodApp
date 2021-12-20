package com.dotanphu.foodapp.activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dotanphu.foodapp.databinding.ItemListFoodBinding
import com.dotanphu.foodapp.model.Food

class FoodAdapter(private var listFood: List<Food>) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.ViewHolder {
        return ViewHolder(
            ItemListFoodBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FoodAdapter.ViewHolder, position: Int) {
        holder.bind(listFood[position])
    }

    override fun getItemCount() = listFood.size

    class ViewHolder(private var binding: ItemListFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food) {
            binding.tvTittle.text = food.tittle
            binding.tvPrice.text = food.price.toString()
        }

    }
}