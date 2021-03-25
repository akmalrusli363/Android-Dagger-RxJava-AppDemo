package com.android.example.daggerrxjavademo.model

import com.google.gson.annotations.SerializedName


data class GitHubUser(
    @SerializedName("login")
    val username: String,
    @SerializedName("public_repos")
    val repoCount: Int,
    @SerializedName("followers")
    val followers: Int,
    @SerializedName("following")
    val following: Int
)