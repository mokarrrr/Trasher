package com.example.trasher.API

import android.nfc.Tag
import android.util.Log
import com.example.trasher.Case
import com.example.trasher.User
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.FileDescriptor


class Connector {
val  RETROFIT:Connection=Retrofit.Builder()
    .baseUrl("http://hnt8.ru:6969/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(SynchronousCallAdapterFactory.create())
    .build()
    .create(Connection::class.java)


    fun auth(password:Int,number:Int): User? {
        Log.d("hi",RETROFIT.auth(password, number).toString())
        return RETROFIT.auth(password, number)
    }

    fun getCases(id:Int):List<Case>{
    return  RETROFIT.cases(id)
    }

    fun add(id: Int,case: Case){
        Log.d("hello",RETROFIT.set(case.title!!,case.description!!,id))
    }
}


