package com.android.example.daggerrxjavademo.injector.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.example.daggerrxjavademo.injector.scope.UserScope
import com.android.example.daggerrxjavademo.view.main.MainViewModel
import com.android.example.daggerrxjavademo.view.viewModel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @UserScope
    abstract fun provideMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @UserScope
    abstract fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}