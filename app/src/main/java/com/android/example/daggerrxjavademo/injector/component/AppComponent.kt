package com.android.example.daggerrxjavademo.injector.component

import android.content.SharedPreferences
import com.android.example.daggerrxjavademo.injector.module.AppModule
import com.android.example.daggerrxjavademo.injector.module.Cached
import com.android.example.daggerrxjavademo.injector.module.NetModule
import com.android.example.daggerrxjavademo.injector.module.NonCached
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetModule::class])
interface AppComponent {
    fun retrofit(): Retrofit

    @Cached
    fun cachedOkHttpClient(): OkHttpClient

    @NonCached
    fun okHttpClient(): OkHttpClient

    fun sharedPreferences(): SharedPreferences
}