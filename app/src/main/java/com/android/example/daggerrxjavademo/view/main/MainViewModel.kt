package com.android.example.daggerrxjavademo.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.example.daggerrxjavademo.model.Repository
import com.android.example.daggerrxjavademo.repository.GitHubRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val gitHubRepository: GitHubRepository) : ViewModel() {
    var searchQuery: String = ""

    private var _repositories: MutableLiveData<List<Repository>> = MutableLiveData()
    val repositories: LiveData<List<Repository>>
        get() = _repositories

    fun fetchData(): List<Repository>? {
        return gitHubRepository.getUserRepository(searchQuery)?.execute()?.body()
    }

    fun setRepositoryData(repositories: List<Repository>) {
        _repositories.postValue(repositories)
    }
}