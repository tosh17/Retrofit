package ru.thstdio.study.retrofit.ex1.ui

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_ex1.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.thstdio.study.retrofit.R

import ru.thstdio.study.retrofit.ex1.api.RandomUserService
import ru.thstdio.study.retrofit.ex1.api.param.Gender
import ru.thstdio.study.retrofit.ex1.mvp.PresenterEx1
import ru.thstdio.study.retrofit.ex1.pojo.UserModel
import ru.thstdio.study.retrofit.glide.GlideApp
import java.util.*


class ActivityEx1 : Activity(), ViewStateEx1 {
    val mPresenter = PresenterEx1(this)
    override fun loadPhoto(url: String) {
        GlideApp.with(baseContext)
            .load(url)
            .circleCrop()
            .placeholder(R.drawable.persona)
            .into(imageView_ex1_logo)
    }

    override fun printName(name: String) {
        textView_ex1_name.text = name
    }

    override fun printGender(gender: String) {
        textView_ex1_gender.text = gender
        main_ex1.setBackgroundColor(
            ContextCompat.getColor(
                baseContext,
                if (gender != Gender.Male.value) R.color.pink
                else R.color.blue
            )
        )
    }

    override fun printJson(json: String) {
        textView_ex1_json.text = json
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex1)
        mPresenter.setMetod(PresenterEx1.Metod.RX)
        btn_ex1_load.setOnClickListener { mPresenter.loadUser() }
    }


    //todo rx
    //todo corutines
    //todo livedata?
    //todo token
    //todo parse headr
    //todo interceptor
    //todo  okhhtp3
    //todo oath2


}
