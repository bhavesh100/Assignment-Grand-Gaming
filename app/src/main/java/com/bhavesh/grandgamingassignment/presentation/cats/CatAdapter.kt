package com.bhavesh.grandgamingassignment.presentation.cats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bhavesh.grandgamingassignment.databinding.ItemCatBinding
import com.bhavesh.grandgamingassignment.domain.model.Cat
import com.bumptech.glide.Glide

class CatAdapter(
    private val onItemClick: (Cat) -> Unit
) : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    private val cats = mutableListOf<Cat>()

    fun submitList(list: List<Cat>) {
        cats.clear()
        cats.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val binding = ItemCatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatViewHolder(binding)
    }

    override fun getItemCount() = cats.size

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(cats[position])
    }

    inner class CatViewHolder(private val binding: ItemCatBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cat: Cat) {
            Glide.with(binding.root)
                .load(cat.imageUrl)
                .into(binding.imageViewCat)

            binding.root.setOnClickListener {
                onItemClick(cat)
            }
        }
    }
}