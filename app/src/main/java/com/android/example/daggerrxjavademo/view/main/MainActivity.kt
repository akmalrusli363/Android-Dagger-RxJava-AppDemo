package com.android.example.daggerrxjavademo.view.main

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.android.example.daggerrxjavademo.databinding.ActivityMainBinding
import com.android.example.daggerrxjavademo.injector.module.Cached
import com.android.example.daggerrxjavademo.injector.module.NonCached
import com.android.example.daggerrxjavademo.model.DataFetcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    @Cached
    lateinit var cachedOkHttpClient: OkHttpClient

    @Inject
    @NonCached
    lateinit var okHttpClient: OkHttpClient

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this

        setContentView(binding.root)

        binding.viewModel = viewModel
        binding.rvRepositories.adapter = RepositoryRecyclerAdapter()
        binding.svUserSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    search(query)
                    return true
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

    }

    private fun search(query: String) {
        viewModel.searchQuery = query
        Log.d("GitSearcher", "Searching... ${viewModel.searchQuery}")

        GlobalScope.run {
            fetchUserProfile(this, query)
            fetchUserRepository(this, query)
        }
    }

    private fun fetchUserProfile(coroutineScope: CoroutineScope, query: String) {
        coroutineScope.launch(Dispatchers.IO) {
            val userProfile = DataFetcher(this@MainActivity).fetchUserProfile(query)
            Log.d("GitSearcher", "Found $userProfile")
            launch(Dispatchers.Main) {
                viewModel.setUserProfile(userProfile)
            }
        }
    }

    private fun fetchUserRepository(coroutineScope: CoroutineScope, query: String) {
        coroutineScope.launch(Dispatchers.IO) {
            val listRepos = DataFetcher(this@MainActivity).fetchRepository(query)
            Log.d("GitSearcher", "Found $listRepos")

            launch(Dispatchers.Main) {
                viewModel.setRepositoryData(listRepos ?: listOf())
                toggleResultAvailability(listRepos != null)
            }
        }
    }

    private fun toggleResultAvailability(available: Boolean) {
        binding.apply {
            if (available) {
                llUserNotExist.visibility = View.GONE
                llUserProfile.visibility = View.VISIBLE
            } else {
                llUserNotExist.visibility = View.VISIBLE
                llUserProfile.visibility = View.GONE
            }
        }
    }
}