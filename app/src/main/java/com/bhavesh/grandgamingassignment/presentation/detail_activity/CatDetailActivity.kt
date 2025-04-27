package com.bhavesh.grandgamingassignment.presentation.detail_activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bhavesh.grandgamingassignment.databinding.ActivityCatDetailBinding
import com.bumptech.glide.Glide

class CatDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCatDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        val catUrl = intent.getStringExtra("cat_url")
        Glide.with(this)
            .load(catUrl)
            .into(binding.imageViewBigCat)
    }
}