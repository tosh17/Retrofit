package ru.thstdio.study.retrofit.ex1.api

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.thstdio.study.retrofit.ex1.pojo.UserModel
import java.util.concurrent.CompletableFuture

interface RandomUserApi {
    @GET("/api")
    fun getData(@Query("gender") Gender: String, @Query("inc") inc: String): Call<UserModel>

    @GET("/api")
    fun getRxREsponde(@Query("gender") Gender: String, @Query("inc") inc: String): Observable<Response<UserModel>>

    @GET("/api")
    fun getFutureData(@Query("gender") Gender: String, @Query("inc") inc: String): CompletableFuture<UserModel>

    @GET("/api")
    fun getStringData(@Query("gender") Gender: String, @Query("inc") inc: String): Call<String>

}