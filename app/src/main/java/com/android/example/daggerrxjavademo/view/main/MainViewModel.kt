package com.android.example.daggerrxjavademo.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.example.daggerrxjavademo.model.GitHubUser
import com.android.example.daggerrxjavademo.model.Repository

class MainViewModel : ViewModel() {
    var searchQuery: String = ""

    private var _repositories: MutableLiveData<List<Repository>> = MutableLiveData()
    val repositories: LiveData<List<Repository>>
        get() = _repositories

    private var _userProfile: MutableLiveData<GitHubUser> = MutableLiveData()
    val userProfile: LiveData<GitHubUser>
        get() = _userProfile

    fun setRepositoryData(repositories: List<Repository>) {
        _repositories.postValue(repositories)
    }

    fun setUserProfile(user: GitHubUser?) {
        _userProfile.postValue(user)
    }

    fun showDisplayName(user: GitHubUser?): String {
        @Suppress("UselessCallOnNotNull")
        return when {
            user == null -> {
                "User not found :("
            }
            user.fullname.isNullOrEmpty() -> {
                "@${userProfile.value?.username}"
            }
            else -> {
                "${user.fullname} (@${user.username})"
            }
        }
    }
}