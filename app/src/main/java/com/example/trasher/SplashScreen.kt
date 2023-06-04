package com.example.trasher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import android.view.ViewPropertyAnimator

lateinit var fadeIn: Animation
lateinit var fadeOut: Animation

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        fadeOut = AnimationUtils.loadAnimation(this@SplashScreen, R.anim.fade_out)
        fadeIn = AnimationUtils.loadAnimation(this@SplashScreen, R.anim.fade_in)
        val layout: ConstraintLayout = findViewById(R.id.root_layout)
        val text: TextView = findViewById(R.id.textView2)
        val img: ImageView = findViewById(R.id.imageView6)
        img.startAnimation(fadeIn)
        text.startAnimation(fadeIn)


        val timerStart = object : CountDownTimer(3000, 1000){
            override fun onTick(p0: Long) {
            }
            override fun onFinish() {


                layout.setBackgroundResource(R.drawable.splash_screen_transition)
                val backgroundAnimation = layout.background as AnimationDrawable
                backgroundAnimation.setEnterFadeDuration(10)
                backgroundAnimation.setExitFadeDuration(2500)
                backgroundAnimation.start()
                img.startAnimation(fadeOut)
                text.startAnimation(fadeOut)

                val timerEnd = object : CountDownTimer(2000, 1000){
                    override fun onTick(p0: Long) {
                    }
                    override fun onFinish() {
                        val intent = Intent(this@SplashScreen, LogInScreen::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
                timerEnd.start()
            }
        }
        timerStart.start()
    }
}


