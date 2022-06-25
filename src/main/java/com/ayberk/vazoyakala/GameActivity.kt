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
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class GameActivity : AppCompatActivity() {

    var score = 0
    var imageArray = ArrayList<ImageView>()
    var handler = Handler()
    var runnable = Runnable {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        Toast.makeText(this@GameActivity, "Biraz ısınalım", Toast.LENGTH_SHORT).show()

        val intent = intent
        val username = intent.getStringExtra("username")

        usernameText10.text= "username:" + username

        imageArray.add(vazo1)
        imageArray.add(imageView3)
        imageArray.add(imageView4)
        imageArray.add(imageView5)
        imageArray.add(imageView6)
        imageArray.add(imageView7)
        imageArray.add(imageView8)
        imageArray.add(imageView9)
        imageArray.add(imageView10)

        hideimages()


        object  : CountDownTimer(15300,1000){
            override fun onTick(p0: Long) {
                timeText.text="Time:" + p0/1000

            }

            override fun onFinish() {
                timeText.text="Time: 0"

                handler.removeCallbacks(runnable)

                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }

                val alert = AlertDialog.Builder(this@GameActivity)

                if(score>10)
                alert.setTitle("Win")
                alert.setMessage("Restart The Game?")
                alert.setPositiveButton("Yes") {dialog,which ->
                    val intent = intent
                    finish()
                    startActivity(intent)
                    Toast.makeText(this@GameActivity, "Tekrar deneyelim", Toast.LENGTH_SHORT).show()
                }
                if(score<10)
                    alert.setTitle("Game Over")
                alert.setNegativeButton("No"){dialog,which ->
                    val intent = Intent(applicationContext,EpisodeActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this@GameActivity, "Tebrikler", Toast.LENGTH_SHORT).show()
                }
                alert.show()
            }

        }.start()

    }

    fun basla(view: View){
        val intent = Intent(applicationContext,MainActivity::class.java)
        intent.putExtra("username",usernameText10.text)
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

                handler.postDelayed(runnable,500)
            }
        }
        handler.post  (runnable)


    }

    fun increaseScore(view: View){
        score++
        scoreText.text = "Score: $score"


    }
}

