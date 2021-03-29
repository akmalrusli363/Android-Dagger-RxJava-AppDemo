package com.android.example.daggerrxjavademo.repository

import com.android.example.daggerrxjavademo.model.Repository
import io.reactivex.Observable
import retrofit2.Call

interface GitHubRepository {
    fun getUserRepository(query:String) : Call<List<Repository>>?
}

