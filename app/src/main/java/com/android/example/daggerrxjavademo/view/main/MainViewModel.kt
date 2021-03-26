package com.android.example.daggerrxjavademo.view.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.example.daggerrxjavademo.model.GitHubUser
import com.android.example.daggerrxjavademo.model.Repository
import com.android.example.daggerrxjavademo.repository.GitHubRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val gitHubRepository: GitHubRepository) :
    ViewModel() {
    var searchQuery: String = ""

    private var _repositories: MutableLiveData<List<Repository>> = MutableLiveData()
    val repositories: LiveData<List<Repository>>
        get() = _repositories

    private var _userProfile: MutableLiveData<GitHubUser> = MutableLiveData()
    val userProfile: LiveData<GitHubUser>
        get() = _userProfile

    private var _resultSuccess: MutableLiveData<Boolean> = MutableLiveData()
    val resultSuccess: LiveData<Boolean>
        get() = _resultSuccess

    private fun setRepositoryData(repositories: List<Repository>) {
        _repositories.postValue(repositories)
    }

    private fun setUserProfile(user: GitHubUser?) {
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

    fun fetchProfile(query: String) {
        run {
            getObservableProfile(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("GitSearcher", "Found $it")
                    setUserProfile(it.first)
                    setRepositoryData(it.second)
                    _resultSuccess.value = (it != null)
                }, {
                    Log.e("GitSearcher", it.localizedMessage, it)
                    _resultSuccess.value = false
                })
        }
    }

    private fun getObservableProfile(
        query: String
    ): Observable<Pair<GitHubUser, List<Repository>>> {
        return gitHubRepository.run {
            Observable.zip(getUserProfile(query), getUserRepository(query),
                BiFunction<GitHubUser, List<Repository>, Pair<GitHubUser, List<Repository>>> { user, repos ->
                    return@BiFunction Pair(user, repos)
                })
        }
    }
}