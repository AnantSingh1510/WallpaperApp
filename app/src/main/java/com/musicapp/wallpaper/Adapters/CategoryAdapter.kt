package com.musicapp.wallpaper.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.musicapp.wallpaper.Models.Category
import com.musicapp.wallpaper.databinding.CategoryWallpaperItemRowBinding

class CategoryAdapter(private val categoryList: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {


    class MyViewHolder(private val binding : CategoryWallpaperItemRowBinding) :
        RecyclerView.ViewHolder(binding.root){

            fun bindData(category: Category){
                binding.nameTextView.text = category.name
                Glide.with(binding.coverImage).load(category.coverUrl)
                    .apply (
                        RequestOptions().transform(RoundedCorners(32))
                    )
                    .into(binding.coverImage)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CategoryWallpaperItemRowBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(categoryList[position])
    }
}