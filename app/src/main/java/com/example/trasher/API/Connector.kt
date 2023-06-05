package com.example.trasher.API

import android.nfc.Tag
import android.util.Log
import com.example.trasher.Case
import com.example.trasher.User
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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

    fun add(id: Int,title: String, description: String){

        val interceptor = HttpLoggingInterceptor()
        interceptor.level= HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder().
        baseUrl("http://hnt8.ru:6969/api/").
        client(client).
        addConverterFactory(GsonConverterFactory.create()).
        addCallAdapterFactory(SynchronousCallAdapterFactory.create()).
        build()

        val api = retrofit.create(Connection::class.java)

//        Log.d("hello",api.set(Add(id,title!!, description!!)))
        Log.d("hello",api.set( title!!, description!!,id))


    }
}


