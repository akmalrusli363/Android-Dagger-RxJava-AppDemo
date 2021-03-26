package com.android.example.daggerrxjavademo.repository

import com.android.example.daggerrxjavademo.model.GitHubUser
import com.android.example.daggerrxjavademo.model.Repository
import io.reactivex.Observable

interface GitHubRepository {
    fun getUserRepository(query: String): Observable<List<Repository>>?
    fun getUserProfile(query: String): Observable<GitHubUser>
}

