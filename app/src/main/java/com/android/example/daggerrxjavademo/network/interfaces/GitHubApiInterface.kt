package com.android.example.daggerrxjavademo.network.interfaces

import com.android.example.daggerrxjavademo.model.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApiInterface {
    @GET("/orgs/{orgName}/repos")
    fun getOrganizationRepository(@Path("orgName") orgName: String): Call<List<Repository>>

    @GET("/users/{userName}/repos")
    fun getUserRepository(@Path("userName") orgName: String): Call<List<Repository>>
}