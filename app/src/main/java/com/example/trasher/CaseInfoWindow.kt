

package com.example.trasher

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

lateinit var thisCase: Case

class CaseInfoWindow : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_case_info_window)

        thisCase = intent.getParcelableExtra("case")!!
       var caseInfo: EditText = findViewById(R.id.editTextCaseInfo)
        var Idcase: TextView = findViewById(R.id.numberofcase)
        caseInfo.setText("Название дела: ${thisCase.title}\n" +
                "Описание: ${thisCase.description}\n")
        Idcase.setText("${thisCase.id}")


    }
    fun sketch (view:android.view.View){
        val intent = Intent(this,SketchWindow::class.java)
        startActivity(intent)

    }
    fun photorobot(view:android.view.View){
        val intent = Intent(this,Photorobot::class.java)
        startActivity(intent)

    }
    fun evidence (view:android.view.View){
        val intent = Intent(this,EvidenceWindow::class.java)
        startActivity(intent)

    }
    fun notes (view:android.view.View){

        val intent = Intent(this,NotesWindow::class.java)
        intent.putExtra("case",thisCase)
        startActivity(intent)

    }
     fun  goshawty(view: View){
        val newActIntent = Intent(this,CaseListWindow::class.java)
        newActIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(newActIntent)

    }

}

