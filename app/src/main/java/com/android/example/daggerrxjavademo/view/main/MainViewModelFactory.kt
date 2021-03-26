package com.android.example.daggerrxjavademo.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.example.daggerrxjavademo.repository.GitHubRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val gitHubRepository: GitHubRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(gitHubRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}