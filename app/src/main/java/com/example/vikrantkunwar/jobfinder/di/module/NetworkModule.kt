package com.example.vikrantkunwar.jobfinder.di.module

import com.example.vikrantkunwar.jobfinder.data.remote.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

private val BASE_URL = "https://a.b.c"

    @Provides
    internal fun provideRetrofit(): Retrofit {


       val gson: Gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()



        return Retrofit.Builder().baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    internal fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create<ApiService>(ApiService::class.java)
    }
}