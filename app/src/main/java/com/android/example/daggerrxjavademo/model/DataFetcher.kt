package com.android.example.daggerrxjavademo.model

import android.app.Activity
import android.util.Log
import com.android.example.daggerrxjavademo.core.MyApplication
import com.android.example.daggerrxjavademo.network.interfaces.GitHubApiInterface
import retrofit2.Retrofit

class DataFetcher(activity: Activity) {
    private val retrofit: Retrofit = (activity.application as MyApplication).getAppComponent().retrofit()

    fun fetchRepository(query: String): List<Repository>? {
        val apiService = retrofit.create(GitHubApiInterface::class.java)
        try {
            return apiService.getUserRepository(query).execute().body()
        } catch (e: Exception) {
            Log.e("GitSearcher", e.localizedMessage, e)
            throw e
        }
    }

    fun fetchUserProfile(query: String): GitHubUser? {
        val apiService = retrofit.create(GitHubApiInterface::class.java)
        try {
            return apiService.getUserProfile(query).execute().body()
        } catch (e: Exception) {
            Log.e("GitSearcher", e.localizedMessage, e)
            throw e
        }
    }
}