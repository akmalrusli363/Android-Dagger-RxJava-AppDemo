package com.android.example.daggerrxjavademo.injector.module

import android.content.Context
import com.android.example.daggerrxjavademo.repository.GitHubRepository
import dagger.Binds

abstract class RepositoryModule {
    @Binds
    abstract fun provideGitHubRepository(context: Context): GitHubRepository
}