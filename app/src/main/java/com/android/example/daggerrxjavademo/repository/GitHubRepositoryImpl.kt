package com.android.example.daggerrxjavademo.repository

import com.android.example.daggerrxjavademo.model.GitHubUser
import com.android.example.daggerrxjavademo.model.Repository
import com.android.example.daggerrxjavademo.network.interfaces.GitHubApiInterface
import io.reactivex.Observable
import javax.inject.Inject

class GitHubRepositoryImpl @Inject constructor(private val githubApiInterface: GitHubApiInterface) :
    GitHubRepository {
    override fun getUserRepository(query: String): Observable<List<Repository>> {
        return githubApiInterface.getUserRepository(query)
    }

    override fun getUserProfile(query: String): Observable<GitHubUser> {
        return githubApiInterface.getUserProfile(query)
    }
}