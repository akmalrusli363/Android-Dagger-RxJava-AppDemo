package com.android.example.daggerrxjavademo.core

import android.app.Application
import com.android.example.daggerrxjavademo.injector.component.AppComponent
import com.android.example.daggerrxjavademo.injector.component.DaggerAppComponent
import com.android.example.daggerrxjavademo.injector.component.DaggerUserComponent
import com.android.example.daggerrxjavademo.injector.component.UserComponent
import com.android.example.daggerrxjavademo.injector.module.AppModule
import com.android.example.daggerrxjavademo.injector.module.GitHubModule
import com.android.example.daggerrxjavademo.injector.module.NetModule

class MyApplication : Application() {
    private lateinit var appComponent: AppComponent
    private lateinit var userComponent: UserComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .netModule(NetModule("https://api.github.com"))
            .build()

        userComponent = DaggerUserComponent.builder()
            .appComponent(appComponent)
            .gitHubModule(GitHubModule()) // this is optional
            .build()
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }
}