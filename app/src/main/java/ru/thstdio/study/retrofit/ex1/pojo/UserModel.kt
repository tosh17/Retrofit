package ru.thstdio.study.retrofit.ex1.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserModel {
    @SerializedName("results")
    @Expose
    lateinit var results: List<ResultsGson>

    fun getResult()= results[0]
    fun getGender() = getResult().gender
    fun getName() = getResult().name.toString()
    fun getPicture()=getResult().picture


    class ResultsGson {
        @SerializedName("gender")
        @Expose
        lateinit var gender: String

        @SerializedName("nat")
        @Expose
        lateinit var nat: String

        @SerializedName("name")
        @Expose
        lateinit var name: NameGson

        class NameGson {
            @SerializedName("title")
            @Expose
            lateinit var title: String

            @SerializedName("first")
            @Expose
            lateinit var first: String

            @SerializedName("last")
            @Expose
            lateinit var last: String

            override fun toString(): String {
                return "$title  $first  $last"
            }
        }

        @SerializedName("picture")
        @Expose
        lateinit var picture: PictureGson

        class PictureGson {
            @SerializedName("large")
            @Expose
            lateinit var large: String

            @SerializedName("medium")
            @Expose
            lateinit var medium: String

            @SerializedName("thumbnail")
            @Expose
            lateinit var thumbnail: String
        }
    }

}