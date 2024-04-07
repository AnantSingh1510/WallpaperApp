package com.musicapp.wallpaper

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.musicapp.wallpaper.Adapters.CategoryAdapter
import com.musicapp.wallpaper.Models.Category
import com.musicapp.wallpaper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var categoryAdapter : CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getCategories()
    }

    fun getCategories(){
        FirebaseFirestore.getInstance().collection("categories")
            .get().addOnSuccessListener {
                val categoryList = it.toObjects(Category::class.java)
                setupCategoryRecyclerView(categoryList)
            }
    }

    private fun setupCategoryRecyclerView(cateoryList: List<Category>) {
        categoryAdapter = CategoryAdapter(cateoryList)
        binding.categoriesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.categoriesRecyclerView.adapter = categoryAdapter
    }
}