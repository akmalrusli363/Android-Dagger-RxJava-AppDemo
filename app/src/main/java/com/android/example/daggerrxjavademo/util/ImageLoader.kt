package com.android.example.daggerrxjavademo.util

import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.android.example.daggerrxjavademo.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.jetbrains.annotations.NotNull

object ImageLoader {
    @DrawableRes val DEFAULT_AVATAR: Int = R.drawable.ic_baseline_person_large

    fun loadImage(imageUrl: String?, imageView: ImageView) {
        if (!imageUrl.isNullOrBlank()) {
            loadImage(LinkUtility.convertToUri(imageUrl), imageView)
        } else {
            loadResourceImage(DEFAULT_AVATAR, imageView)
        }
    }

    fun loadImage(imageUri: Uri?, imageView: ImageView) {
        if (imageUri != null){
            Glide.with(imageView)
                .load(imageUri)
                .apply(
                    RequestOptions()
                        .placeholder(DEFAULT_AVATAR)
                        .error(R.drawable.ic_baseline_error_large))
                .into(imageView)
        } else {
            loadResourceImage(DEFAULT_AVATAR, imageView)
        }
    }

    fun loadResourceImage(@NotNull @DrawableRes imageRes: Int, imageView: ImageView) {
        imageView.setImageResource(imageRes)
    }
}