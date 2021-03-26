package com.android.example.daggerrxjavademo.util

import android.net.Uri
import androidx.core.net.toUri

object LinkUtility {
    fun convertToUri(url: String): Uri {
        return url.toUri().buildUpon().scheme("https").build()
    }
}