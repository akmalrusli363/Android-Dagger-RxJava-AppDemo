package com.android.example.daggerrxjavademo.view.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.android.example.daggerrxjavademo.core.MyApplication
import com.android.example.daggerrxjavademo.databinding.ActivityMainBinding
import com.android.example.daggerrxjavademo.injector.component.UserComponent
import com.android.example.daggerrxjavademo.view.viewModel.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: ActivityMainBinding
    private lateinit var userComponent: UserComponent

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userComponent = (application as MyApplication).getUserComponent()
        userComponent.inject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this

        setContentView(binding.root)

        binding.viewModel = viewModel
        binding.rvRepositories.adapter = RepositoryRecyclerAdapter()
        binding.svUserSearch.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
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

        Thread {
            val result = viewModel.fetchData()
            Log.d("GitSearcher", "Found $result")
            runOnUiThread {
                viewModel.setRepositoryData(result ?: listOf())
                toggleResultAvailability(result != null)
            }
        }.start()
    }

    private fun toggleResultAvailability(available:Boolean) {
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