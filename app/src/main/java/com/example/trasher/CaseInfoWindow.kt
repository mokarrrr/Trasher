package com.example.trasher

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton

lateinit var thisCase: Case

class CaseInfoWindow : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_case_info_window)

        thisCase = intent.getParcelableExtra("case")!!
       var caseInfo: EditText = findViewById(R.id.editTextCaseInfo)
       /* caseInfo.setText("Имя подозреваемого: ${thisCase.SuspectName}\n" +
                "Фамилия подозреваемого: ${thisCase.SuspectSurname}\n" +
                "Отчество подозреваемого: ${thisCase.SuspectThirdname}\n" +
                "Примерный возраст подозреваемого: ${thisCase.Age.toString()}\n" +
                "Описание дела: ${thisCase.CaseInfo}")*/


    }
    fun sketch (view:android.view.View){
        val intent = Intent(this,SketchWindow::class.java)
        startActivity(intent)
        finish()
    }
    fun photorobot(view:android.view.View){
        val intent = Intent(this,Photorobot::class.java)
        startActivity(intent)
        finish()
    }
    fun evidence (view:android.view.View){
        val intent = Intent(this,EvidenceWindow::class.java)
        startActivity(intent)
        finish()
    }
    fun notes (view:android.view.View){
        val intent = Intent(this,NotesWindow::class.java)
        startActivity(intent)
        finish()
    }
    fun back (view:android.view.View){
        val intent = Intent(this,CaseListWindow::class.java)
        startActivity(intent)
        finish()
    }

}