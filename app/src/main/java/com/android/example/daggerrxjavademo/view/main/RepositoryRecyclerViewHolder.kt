package com.android.example.daggerrxjavademo.view.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.android.example.daggerrxjavademo.databinding.RvRepositoryItemBinding
import com.android.example.daggerrxjavademo.model.Repository

class RepositoryRecyclerViewHolder(private val itemBinding: RvRepositoryItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    private lateinit var item: Repository
    private val noDescriptionString: String = "-- No description available --"

    fun bind(repositoryItem: Repository) {
        item = repositoryItem
        itemBinding.apply {
            tvRepositoryName.text = item.name
            tvRepositoryFullname.text = item.fullName
            tvDescription.text = item.description ?: noDescriptionString
            root.setOnClickListener {
                visitRepositoryLink(it.context, item)
            }
            executePendingBindings()
        }
    }

    private fun visitRepositoryLink(context: Context, repository: Repository) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(repository.repositoryURL)
        context.startActivity(intent)
    }
}