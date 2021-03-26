package com.android.example.daggerrxjavademo.injector.module

import com.android.example.daggerrxjavademo.injector.scope.UserScope
import com.android.example.daggerrxjavademo.repository.GitHubRepository
import com.android.example.daggerrxjavademo.repository.GitHubRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    @UserScope
    abstract fun provideGitHubRepository(gitHubRepository: GitHubRepositoryImpl): GitHubRepository
}