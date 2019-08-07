package ru.thstdio.study.retrofit.ex1.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.thstdio.study.retrofit.ex1.pojo.UserModel

interface RandomUserApi {
    @GET("/api")
    fun getData(@Query("gender") Gender: String, @Query("inc") inc: String): Call<UserModel>

    @GET("/api")
    fun getStringData(@Query("gender") Gender: String, @Query("inc") inc: String): Call<String>

}