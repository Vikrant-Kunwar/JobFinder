package com.example.vikrantkunwar.jobfinder.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.vikrantkunwar.jobfinder.di.util.ViewModelKey
import com.example.vikrantkunwar.jobfinder.ui.main.MainActivityViewModel
import com.example.vikrantkunwar.jobfinder.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {



    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel



    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory):ViewModelProvider.Factory

}