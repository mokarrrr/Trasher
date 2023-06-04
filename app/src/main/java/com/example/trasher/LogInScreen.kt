package com.example.trasher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.trasher.API.Connector


/*val users = arrayOf(User(123456, "Иван", "Иванович", "123456" ),
    User(789012, "Михаил", "Михайлович", "qwerty"))*/

class LogInScreen : AppCompatActivity() {

    lateinit var Id: EditText
    lateinit var Pas: EditText
    lateinit var LogError: TextView
    lateinit var PasError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_screen)

        val anim: Animation = AnimationUtils.loadAnimation(this@LogInScreen, R.anim.fade_in)
        Id = findViewById(R.id.editTextID)
        Pas = findViewById(R.id.editTextPassword)
        LogError = findViewById(R.id.textViewLoginError)
        PasError = findViewById(R.id.textViewPasswordError)
        val Gerb: ImageView = findViewById(R.id.Gerb)
        val LogInButton: Button = findViewById(R.id.ButtonLogIn)
        Id.startAnimation(anim)
        Pas.startAnimation(anim)
        Gerb.startAnimation(anim)
        LogInButton.startAnimation(anim)
    }

    fun sign(view: android.view.View) {
        var intId = Integer.parseInt(Id.getText().toString())
        var intPas = Integer.parseInt(Pas.getText().toString())
        LogError.visibility = View.GONE
        PasError.visibility = View.GONE

        var user:User?= null
        Thread(Runnable {
           try {
               user = Connector().auth(intId,intPas)
               Log.d("hi",user.toString())

               if(user == null) {
                   PasError.visibility = View.VISIBLE
               }
               else {
                   val intent = Intent(this, WelcomeScreen::class.java)
                   intent.putExtra("user", user)
                   startActivity(intent)
                   finish()
               }
           }
            catch (e:Exception){
                e.printStackTrace()
            }

        }).start()

        /*if(user == null) {
            PasError.visibility = View.VISIBLE
        }
        else {
            val intent = Intent(this, WelcomeScreen::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
            finish()
        }*/
    }
   /* fun isExist(id: Int): Boolean{
     var res = false
     for (user in users){
         if(user.ID == id){
             res = true
             break
         }
     }
        return res
    }
    fun checkPas(id: Int, pas: String):Boolean{
        var res = false
        for(user in users){
            if(isExist(id) && user.Password == pas)
            {
                res = true
                break
            }
        }
        return res
    }
    fun getUser(id: Int): User {
        var res = User(0, "", "", "")
        for(user in users){
            if(user.ID == id){
                res = user
            }
        }
        return res
    }*/
}


