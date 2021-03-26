package com.android.example.daggerrxjavademo.repository

import com.android.example.daggerrxjavademo.model.Repository
import com.android.example.daggerrxjavademo.network.interfaces.GitHubApiInterface
import io.reactivex.Observable
import retrofit2.Call
import javax.inject.Inject

class GitHubRepositoryImpl @Inject constructor(private val githubApiInterface: GitHubApiInterface) :
    GitHubRepository {
    override fun getUserRepository(query: String): Call<List<Repository>>? {
        return githubApiInterface.getUserRepository(query)
    }
}