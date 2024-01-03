package com.example.apiapplication.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.bumptech.glide.Glide
import com.example.apiapplication.R
import com.example.apiapplication.databinding.ListItemBinding

class ItemAdapter() : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private var dataset = listOf<String>()

    inner class ItemViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)


    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newList: List<String>) {
        dataset = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val image = dataset[position]
        // COIL
        /*
        holder.binding.ivDogImage.load(image) {
            error(R.drawable.ic_launcher_foreground)
            placeholder(R.drawable.ic_launcher_background)
            transformations(RoundedCornersTransformation(50f))
        }

         */
        // Glide
        Glide.with(holder.binding.root)
            .load(image)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.binding.ivDogImage)
    }
}