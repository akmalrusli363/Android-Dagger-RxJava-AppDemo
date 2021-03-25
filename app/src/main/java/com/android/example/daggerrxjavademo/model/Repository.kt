package com.android.example.daggerrxjavademo.model

import com.google.gson.annotations.SerializedName

data class Repository(
    @SerializedName("html_url")
    val repositoryURL: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("full_name")
    val fullName: String? = null,
    @SerializedName("description")
    val description: String? = null,
)
