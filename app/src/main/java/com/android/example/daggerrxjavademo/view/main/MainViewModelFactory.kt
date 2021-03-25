package com.android.example.daggerrxjavademo.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import retrofit2.Retrofit
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val retrofit: Retrofit) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(retrofit) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}