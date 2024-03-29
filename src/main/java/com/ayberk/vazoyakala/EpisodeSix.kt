package com.ayberk.vazoyakala

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_episode_five.*
import kotlinx.android.synthetic.main.activity_episode_one.*
import kotlinx.android.synthetic.main.activity_episode_one.vazo10
import kotlinx.android.synthetic.main.activity_episode_one.vazo2
import kotlinx.android.synthetic.main.activity_episode_one.vazo3
import kotlinx.android.synthetic.main.activity_episode_one.vazo4
import kotlinx.android.synthetic.main.activity_episode_one.vazo5
import kotlinx.android.synthetic.main.activity_episode_one.vazo6
import kotlinx.android.synthetic.main.activity_episode_one.vazo7
import kotlinx.android.synthetic.main.activity_episode_one.vazo8
import kotlinx.android.synthetic.main.activity_episode_one.vazo9
import kotlinx.android.synthetic.main.activity_episode_six.*
import java.util.*
import kotlin.collections.ArrayList

class EpisodeSix : AppCompatActivity() {

    var score = 0
    var imageArray = ArrayList<ImageView>()
    var handler = Handler()
    var runnable = Runnable {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episode_six)


        imageArray.add(vazo2)
        imageArray.add(vazo3)
        imageArray.add(vazo4)
        imageArray.add(vazo5)
        imageArray.add(vazo6)
        imageArray.add(vazo7)
        imageArray.add(vazo8)
        imageArray.add(vazo9)
        imageArray.add(vazo10)

        hideimages()


        object  : CountDownTimer(15300,1000){
            override fun onTick(p0: Long) {
                timeText6.text="Time:" + p0/1000
            }

            override fun onFinish() {
                timeText6.text="Time: 0"

                handler.removeCallbacks(runnable)

                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }

                val alert = AlertDialog.Builder(this@EpisodeSix)

                if(score>=10)
                    alert.setTitle("Win")
                alert.setMessage("Restart The Game?")
                alert.setPositiveButton("Yes") {dialog,which ->
                    val intent = intent
                    finish()
                    startActivity(intent)
                    Toast.makeText(this@EpisodeSix, "Tekrar deneyelim", Toast.LENGTH_SHORT).show()

                }
                if(score<10)
                    alert.setTitle("Game Over")
                alert.setNegativeButton("No"){dialog,which ->
                    val intent = Intent(applicationContext,EpisodeActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this@EpisodeSix, "Her Güzel Şeyin Sonu Olduğu Gibi Bu Oyununda Sonuna Geldin", Toast.LENGTH_LONG).show()
                }
                alert.show()
            }

        }.start()

    }

    fun bolumone(view: View){
        val intent = Intent(applicationContext,EpisodeOne::class.java)
        startActivity(intent)
    }

    fun hideimages(){

        runnable = object : Runnable{
            override fun run(){
                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }
                val random = Random()
                val randomIndex = random.nextInt(9)
                imageArray[randomIndex].visibility = View.VISIBLE

                handler.postDelayed(runnable,400)
            }
        }
        handler.post  (runnable)


    }

    fun increaseScore(view: View){
        score++
        scoreText7.text = "Score: $score"

    }

    fun decrease(view: View){
        score--
        scoreText7.text = "Score: $score"
    }
}

