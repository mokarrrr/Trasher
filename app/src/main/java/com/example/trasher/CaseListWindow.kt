package com.example.trasher

import android.content.Intent
import android.graphics.Color
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trasher.API.Connector
import com.example.trasher.databinding.ActivityCaseListWindowBinding
import com.example.trasher.databinding.CaseListItemBinding
import retrofit2.Retrofit

/*val cases = arrayListOf(Case(0,"Иван","Скворцов","Алексеевич",42,"Украл творожный сырок",null, null),
Case(1,"Николай","Козлов","Николаевич",38,"Украл кота",null, null),
Case(2,"Федор","Синицын","Ифанович",20,"Обоссал забор",null, null))*/

class CaseListWindow : AppCompatActivity(), CaseAdapter.Listener {

    lateinit var binding: ActivityCaseListWindowBinding
    private val adapter = CaseAdapter(this)
    private var caseid = 0
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCaseListWindowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        user = intent.getParcelableExtra<User>("user")!!
        binding.rcView.layoutManager = GridLayoutManager(this@CaseListWindow, 2)
        binding.rcView.adapter = adapter
        getCases()
    }

//    private fun init(){
//        binding.apply {
//            rcView.layoutManager = GridLayoutManager(this@CaseListWindow, 2)
//            rcView. adapter = adapter
//            NewCaseLayout.setOnClickListener{
//                val case = Case(caseid, "", "", "", "", "", null, null)
//                adapter.addCase(case)
//                caseid++
//            }
//        }
//    }

    fun newCaseButton(){
        binding.apply {
            NewCaseLayout.setOnClickListener{
                val intent = Intent(this@CaseListWindow, NewCaseWindow::class.java)
                startActivityForResult(intent, 0)
            }
        }
    }

    fun getCases(){
        val rc = findViewById<RecyclerView>(R.id.rcView)
        Thread(Runnable {
            var userCases: List<Case>?=Connector().getCases(user.id)
            rc.post(Runnable { adapter.setList(ArrayList(userCases)) })
                Log.d("hi", userCases?.first().toString())
        })
            .start()

        // userCases = user.CaseList
       /* if(userCases != null){
            for(userCasesId in userCases){
                *//*adapter.addCase()*//*
            }
        }*/
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onClick(case: Case) {
        val intent = Intent(this@CaseListWindow, CaseInfoWindow::class.java)
        intent.putExtra("case", case)
        startActivity(intent)
    }

    fun LogOut(view: android.view.View){
        startActivity(Intent(this@CaseListWindow, LogInScreen::class.java))
        finish()
    }
    fun goshawty (view:android.view.View){
        val intent = Intent(this,NewCaseWindow::class.java)
        startActivity(intent)
    }

    fun searchButton(view: android.view.View) {
        binding.apply {
            adapter.clearList()
            getCases()
            if (editTextSearch.length() != 0) {
                for (case in adapter.getList()) {
                    if (case.id != Integer.parseInt(editTextSearch.getText().toString())) {
                        adapter.delCase(case)
                    }
                }
            }
        }
    }
}