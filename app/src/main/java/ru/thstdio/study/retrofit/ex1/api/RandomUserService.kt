package ru.thstdio.study.retrofit.ex1.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

class RandomUserService {
    companion object {
        val instance = RandomUserService()
        val INC = "gender,name,nat,picture"
    }

    private val mRetrofit: Retrofit
    private val mRetrofitString: Retrofit
    val BASE_URL = "https://randomuser.me"


    init {

        mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        mRetrofitString = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    fun createRandomUserApi() = mRetrofit.create(RandomUserApi::class.java)
    fun createRandomUserStringApi()=mRetrofitString.create(RandomUserApi::class.java)


}