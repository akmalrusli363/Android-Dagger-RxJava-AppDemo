package com.android.example.daggerrxjavademo.view.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.example.daggerrxjavademo.model.Repository
import com.android.example.daggerrxjavademo.model.RepositoryFetcher

class MainViewModel : ViewModel() {
    var searchQuery: String = ""

    private var _repositories: MutableLiveData<List<Repository>> = MutableLiveData()
    val repositories: LiveData<List<Repository>>
        get() = _repositories

    private fun search(query: String) {
        searchQuery = query
        Log.e("GitSearcher", "Searching... on blank")

//        val result = RepositoryFetcher(this).fetchRepository(searchQuery)
//        if (result != null) {
//            repositories.addAll(result)
//        }
    }

    fun setRepositoryData(repositories: List<Repository>) {
        _repositories.postValue(repositories)
    }
}