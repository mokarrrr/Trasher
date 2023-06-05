package com.example.trasher

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.trasher.API.Connector
import com.example.trasher.databinding.ActivityNewCaseWindowBinding

class NewCaseWindow : AppCompatActivity() {

    lateinit var binding: ActivityNewCaseWindowBinding
    private val viewModel: UserViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_case_window)
        binding = ActivityNewCaseWindowBinding.inflate(layoutInflater)


//        binding.apply {
//
//            imageView3.setOnClickListener {
//                Log.d("Кнопка","Нажата")
//                Connector().add(user!!.id,editTextSuspectThirdname.text.toString(),editTextSuspectDiscription.text.toString())
//            }
//        }


    }

    /*fun SaveButton(view: android.view.View){
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
    fun save (view:android.view.View){
        Thread(Runnable {
            val settings = getSharedPreferences("User", MODE_PRIVATE)
            val id: String = settings.getString("User", "не определено")!!
            binding = ActivityNewCaseWindowBinding.inflate(layoutInflater)
            val t = findViewById<EditText>(R.id.editTextSuspectThirdname)
            val d = findViewById<EditText>(R.id.editTextSuspectDiscription)
//            val title = binding.editTextSuspectThirdname.text.toString()
//            val description = binding.editTextSuspectDiscription.text.toString()
            val title = t.text.toString()
            val description = d.text.toString()
            Log.d("Поля",title + description)

            Connector().add(id.toInt(),title,description)
        }).start()


    }
}