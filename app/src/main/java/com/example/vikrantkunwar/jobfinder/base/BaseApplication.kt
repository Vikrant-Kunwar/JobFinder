package com.example.vikrantkunwar.jobfinder.base

import com.example.vikrantkunwar.jobfinder.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        val component = DaggerApplicationComponent.builder().application(this).build()

        component.inject(this)

        return component
    }
}