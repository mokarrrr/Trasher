package com.example.trasher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trasher.databinding.ActivityCaseListWindowBinding
import com.example.trasher.databinding.ActivityNewCaseWindowBinding

class NewCaseWindow : AppCompatActivity() {

    lateinit var binding: ActivityNewCaseWindowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_case_window)

        binding = ActivityNewCaseWindowBinding.inflate(layoutInflater)


    }

   /* fun SaveButton(view: android.view.View){
        binding.apply {
            linearLayoutSave.setOnClickListener{
                val intent = Intent()
                var name = editTextSuspectName.getText().toString()
                var surname = editTextSuspectSurname.getText().toString()
                var thirdname = editTextSuspectThirdname.getText().toString()
                var age = Integer.parseInt(editTextSuspectAge.getText().toString())
                var caseInfo = editTextSuspectDiscription.getText().toString()
                intent.putExtra("case", Case(0, name, surname, thirdname, age, caseInfo, null, null))
                setResult(RESULT_OK, intent)
                finish()
            }

        }

    }*/
}