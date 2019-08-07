package ru.thstdio.study.retrofit

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ru.thstdio.study.retrofit.ex1.ui.ActivityEx1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startMyActivity("ex1")
    }

    fun startMyActivity(number: String) {
        startActivity(
            Intent(
                this,
                when (number) {
                    "ex1" -> ActivityEx1::class.java
                    else -> ActivityEx1::class.java
                }
            )
        )
        finish()
    }
}
