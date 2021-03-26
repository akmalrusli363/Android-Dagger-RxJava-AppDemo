package com.android.example.daggerrxjavademo.model

import com.google.gson.annotations.SerializedName


data class GitHubUser(
    @SerializedName("html_url")
    val profileURL: String,
    @SerializedName("login")
    val username: String,
    @SerializedName("name")
    val fullname: String,
    @SerializedName("avatar_url")
    val avatarURL: String?,
    @SerializedName("public_repos")
    val repoCount: Int,
    @SerializedName("followers")
    val followers: Int,
    @SerializedName("following")
    val following: Int
)