package com.android.example.daggerrxjavademo.network.interfaces

import com.android.example.daggerrxjavademo.model.Repository
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApiInterface {
    @GET("/users/{userName}/repos")
    fun getUserRepository(@Path("userName") userName: String): Observable<List<Repository>>
}