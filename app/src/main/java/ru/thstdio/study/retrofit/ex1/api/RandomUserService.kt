package ru.thstdio.study.retrofit.ex1.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RandomUserService {
    companion object {
        val instance = RandomUserService()
        val INC="gender,name,nat,picture"
    }

    private val mRetrofit: Retrofit
    val BASE_URL = "https://randomuser.me"


    init {

        mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun createRandomUserApi() = mRetrofit.create(RandomUserApi::class.java)

}