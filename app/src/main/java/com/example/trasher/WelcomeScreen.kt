package com.example.trasher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import android.os.CountDownTimer

class WelcomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)

        val user = intent.getParcelableExtra<User>("user")
        val name = user?.name.toString()
        val surname = user?.surname.toString()
        val greetings: TextView = findViewById(R.id.textViewGreetings)
        greetings.setText("Здравствуйте $name $surname!")

        val timer = object : CountDownTimer(3000, 1000) {
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                val intent = Intent(this@WelcomeScreen, CaseListWindow::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }
        }
        timer.start()
    }
}
