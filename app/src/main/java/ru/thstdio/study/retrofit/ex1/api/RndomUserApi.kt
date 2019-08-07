package ru.thstdio.study.retrofit.ex1.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RndomUserApi {
    @GET("/api")
    fun getData(@Query("gender") Gender: String, @Query("inc") inc: String): Call<List<PostModel>>
}