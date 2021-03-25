package com.android.example.daggerrxjavademo.model

import com.google.gson.annotations.SerializedName

data class Repository(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("full_name")
    val fullName: String? = null,
    @SerializedName("description")
    val description: String? = null,
)
