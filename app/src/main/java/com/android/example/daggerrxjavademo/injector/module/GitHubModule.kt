package com.android.example.daggerrxjavademo.injector.module

import com.android.example.daggerrxjavademo.injector.scope.UserScope
import com.android.example.daggerrxjavademo.network.interfaces.GitHubApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [RepositoryModule::class])
class GitHubModule {
    @Provides
    @UserScope
    fun providesGitHubInterface(@Reactive reactiveRetrofit: Retrofit): GitHubApiInterface {
        return reactiveRetrofit.create(GitHubApiInterface::class.java)
    }
}
