package com.ayberk.vazoyakala

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_main.*

class introActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val mainHandler = Handler(Looper.getMainLooper()).postDelayed ({
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }, 2000)
    }
}