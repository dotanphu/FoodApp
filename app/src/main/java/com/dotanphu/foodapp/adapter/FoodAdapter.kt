package com.dotanphu.foodapp.adapter

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dotanphu.foodapp.databinding.ItemListFoodBinding
import com.dotanphu.foodapp.model.Food
import android.R
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import com.dotanphu.foodapp.activity.CartActivity


class FoodAdapter(
        private var listFood: List<Food>,
        private var context: Context) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListFoodBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), context
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listFood[position])
    }

    override fun getItemCount() = listFood.size

    class ViewHolder(private var binding: ItemListFoodBinding, private var context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food) {
            binding.tvTittle.text = food.tittle
            Glide.with(context).load(food.pic).into(binding.imgPic)
            binding.tvPrice.text = food.price.toString()

            binding.btnAdd.setOnClickListener {
                val dialog = Dialog(context)
                dialog.setContentView(com.dotanphu.foodapp.R.layout.added)
                dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
                dialog.show()
            }
        }
    }
}