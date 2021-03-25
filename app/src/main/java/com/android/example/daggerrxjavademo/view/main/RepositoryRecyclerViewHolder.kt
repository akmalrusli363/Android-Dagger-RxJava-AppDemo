package com.android.example.daggerrxjavademo.view.main

import androidx.recyclerview.widget.RecyclerView
import com.android.example.daggerrxjavademo.databinding.RvRepositoryItemBinding
import com.android.example.daggerrxjavademo.model.Repository

class RepositoryRecyclerViewHolder(private val itemBinding: RvRepositoryItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    private lateinit var item: Repository
    private val noDescriptionString: String = "-- No description available --"

    fun bind(repositoryItem: Repository) {
        item = repositoryItem
        item.apply {
            itemBinding.tvRepositoryName.text = name
            itemBinding.tvRepositoryFullname.text = fullName
            itemBinding.tvDescription.text = description ?: noDescriptionString
            itemBinding.executePendingBindings()

        }
    }

//    private fun addOnClickListener(repositoryItem: Repository) {
//        itemBinding.root.setOnClickListener {
//            val intent =
//        }
//    }
}