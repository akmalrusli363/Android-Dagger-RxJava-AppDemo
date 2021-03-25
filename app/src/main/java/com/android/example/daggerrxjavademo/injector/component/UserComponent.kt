package com.android.example.daggerrxjavademo.injector.component

import com.android.example.daggerrxjavademo.injector.module.GitHubModule
import com.android.example.daggerrxjavademo.injector.scope.UserScope
import com.android.example.daggerrxjavademo.view.main.MainActivity
import dagger.Component

@UserScope
@Component(dependencies = [AppComponent::class], modules = [GitHubModule::class])
interface UserComponent {
    fun inject(activity: MainActivity)
}