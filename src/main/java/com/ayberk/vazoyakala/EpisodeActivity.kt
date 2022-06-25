package com.ayberk.vazoyakala

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class EpisodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episode)

    }

    fun bolumone(view: View) {
        val intent = Intent(applicationContext, EpisodeOne::class.java)
        startActivity(intent)
    }

    fun bolumtwo(view: View) {
        val intent = Intent(applicationContext, EpisodeTwo::class.java)
        startActivity(intent)
    }

    fun bolumthree(view: View) {
        val intent = Intent(applicationContext, EpisodeThree::class.java)
        startActivity(intent)
    }

    fun bolumfour(view: View) {
        val intent = Intent(applicationContext, EpisodeFour::class.java)
        startActivity(intent)
    }
    fun bolumfive(view: View) {
        val intent = Intent(applicationContext, EpisodeFive::class.java)
        startActivity(intent)
    }
    fun bolumsix(view: View) {
        val intent = Intent(applicationContext, EpisodeSix::class.java)
        startActivity(intent)
    }
}



