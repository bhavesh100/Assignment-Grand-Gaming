package com.bhavesh.grandgamingassignment.presentation.main_activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bhavesh.grandgamingassignment.presentation.detail_activity.CatDetailActivity
import com.bhavesh.grandgamingassignment.databinding.ActivityMainBinding
import com.bhavesh.grandgamingassignment.presentation.cats.CatAdapter
import com.bhavesh.grandgamingassignment.presentation.cats.CatViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var catAdapter: CatAdapter
    private val viewModel: CatViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        setupRecyclerView()
        observeState()
    }

    private fun setupRecyclerView() {
        catAdapter = CatAdapter { cat ->
            val intent = Intent(this, CatDetailActivity::class.java)
            intent.putExtra("cat_url", cat.imageUrl)
            startActivity(intent)
        }
        binding.recyclerView.adapter = catAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun observeState() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { catListState ->
                binding.progressBar.isVisible = catListState.isLoading

                if (catListState.error.isNotBlank()) {
                    Toast.makeText(this@MainActivity, catListState.error, Toast.LENGTH_SHORT).show()
                }

                catListState.cats.let { cats ->
                    catAdapter.submitList(cats)
                }
            }
        }
    }
}