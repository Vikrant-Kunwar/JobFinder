package com.example.vikrantkunwar.jobfinder.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


@Module
class AppModule {


    @Provides
    fun compositeProvider(): CompositeDisposable{
        return CompositeDisposable()
    }

}