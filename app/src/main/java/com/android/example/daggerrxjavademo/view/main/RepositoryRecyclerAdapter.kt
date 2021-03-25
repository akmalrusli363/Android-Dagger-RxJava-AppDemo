package com.android.example.daggerrxjavademo.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.android.example.daggerrxjavademo.databinding.RvRepositoryItemBinding
import com.android.example.daggerrxjavademo.model.Repository

class RepositoryRecyclerAdapter() :
    ListAdapter<Repository, RepositoryRecyclerViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepositoryRecyclerViewHolder {
        return RepositoryRecyclerViewHolder(
            RvRepositoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RepositoryRecyclerViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Repository>() {
        override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
            return oldItem.fullName == newItem.fullName
        }

        override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
            return oldItem === newItem
        }
    }
}