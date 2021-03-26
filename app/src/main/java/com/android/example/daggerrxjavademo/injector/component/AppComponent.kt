package com.android.example.daggerrxjavademo.injector.component

import android.content.SharedPreferences
import com.android.example.daggerrxjavademo.injector.module.*
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetModule::class])
interface AppComponent {
    @Callback
    fun retrofit(): Retrofit

    @Reactive
    fun reactiveRetrofit(): Retrofit

    @Cached
    fun cachedOkHttpClient(): OkHttpClient

    @NonCached
    fun okHttpClient(): OkHttpClient

    fun sharedPreferences(): SharedPreferences
}