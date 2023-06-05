package com.example.trasher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton

class NotesWindow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_window)

        thisCase = intent.getParcelableExtra("case")!!
        var notes: EditText = findViewById(R.id.notes1)
        notes.setText("${thisCase.notes}")


    }
     fun  backk(view: View){
        val newActIntent = Intent(this,CaseInfoWindow::class.java)
        newActIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(newActIntent)

    }
}