package com.android.example.daggerrxjavademo.repository

import com.android.example.daggerrxjavademo.core.MyApplication
import com.android.example.daggerrxjavademo.model.Repository
import io.reactivex.Observable
import retrofit2.Retrofit

class GitHubRepositoryImpl : GitHubRepository {
    private val retrofit: Retrofit =
        (activity.application as MyApplication).getAppComponent().retrofit()

    override fun getUserRepository(query: String): Observable<List<Repository>>? {
        val apiService =
            return apiService.getUserRepository(query)
    }
}