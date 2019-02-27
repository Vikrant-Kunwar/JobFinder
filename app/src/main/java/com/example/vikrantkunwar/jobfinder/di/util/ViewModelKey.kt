package com.example.vikrantkunwar.jobfinder.di.util

import android.arch.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@kotlin.annotation.Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)
