package com.android.example.daggerrxjavademo.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.example.daggerrxjavademo.model.Repository

class MainViewModel : ViewModel() {
    var searchQuery: String = ""

    private var _repositories: MutableLiveData<List<Repository>> = MutableLiveData()
    val repositories: LiveData<List<Repository>>
        get() = _repositories

    fun setRepositoryData(repositories: List<Repository>) {
        _repositories.postValue(repositories)
    }
}