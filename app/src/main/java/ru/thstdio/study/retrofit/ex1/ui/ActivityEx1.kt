package ru.thstdio.study.retrofit.ex1.ui

import android.graphics.Color
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
import ru.thstdio.study.retrofit.ex1.pojo.UserModel
import ru.thstdio.study.retrofit.glide.GlideApp
import java.util.*


class ActivityEx1 : AppCompatActivity() {

    private val random = Random()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex1)
        btn_ex1_load.setOnClickListener { loads() }
    }

    private fun loads() {
        val gender = if (random.nextBoolean()) Gender.Male.value else Gender.Female.value
        RandomUserService.instance.createRandomUserApi()
            .getData(gender, RandomUserService.INC)
            .enqueue(object : Callback<UserModel> {
                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                    textView_ex1_name.text = t.toString()
                }

                override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                    val user = response.body()
                    user?.let {
                        textView_ex1_gender.text = it.getGender()
                        textView_ex1_name.text = it.getName()
                        main_ex1.setBackgroundColor(
                            ContextCompat.getColor(
                                baseContext,
                                if (it.getGender() != Gender.Male.value) R.color.pink
                                else R.color.blue
                            )
                        )
                        GlideApp.with(baseContext)
                            .load(it.getPicture().large)
                            .fitCenter()
                            .placeholder(R.drawable.persona)
                            .into(imageView_ex1_logo)
                    }
                }
            })
    }
}
