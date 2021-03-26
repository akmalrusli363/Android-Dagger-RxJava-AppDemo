package com.android.example.daggerrxjavademo.view

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.example.daggerrxjavademo.model.Repository
import com.android.example.daggerrxjavademo.util.ImageLoader
import com.android.example.daggerrxjavademo.view.main.RepositoryRecyclerAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Repository>?) {
    val adapter = recyclerView.adapter as RepositoryRecyclerAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageURL")
fun loadImageFromUrl(imageView: ImageView, imageUrl: String?) {
    ImageLoader.loadImage(imageUrl, imageView)
}