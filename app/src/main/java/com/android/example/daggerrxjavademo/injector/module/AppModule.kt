package com.android.example.daggerrxjavademo.injector.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule constructor(private var myApplication: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return myApplication
    }

}