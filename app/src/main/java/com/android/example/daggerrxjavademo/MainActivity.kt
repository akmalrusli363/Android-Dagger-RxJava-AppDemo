package com.android.example.daggerrxjavademo

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.example.daggerrxjavademo.core.MyApplication
import com.android.example.daggerrxjavademo.injector.module.Cached
import com.android.example.daggerrxjavademo.injector.module.NonCached
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}