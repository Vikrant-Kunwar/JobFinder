package com.example.vikrantkunwar.jobfinder.data.remote

import com.example.vikrantkunwar.jobfinder.data.model.Job
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {

    @Headers("Content-Type: application/json")
    @GET
    fun jobs(@Url url:String,
             @Query("query")query:String,
            @Query("description")description: String,
            @Query("location")location: String,
             @Query("full_time")full_time:String): Single<List<Job>>


//    @Headers("Content-Type: application/json")
//    @GET
//    fun jobs(@Url url:String,
//             @Query("query")query:String): Single<List<Job>>
}