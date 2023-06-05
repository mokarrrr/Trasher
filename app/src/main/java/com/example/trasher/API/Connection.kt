package com.example.trasher.API

import com.example.trasher.Case
import retrofit2.http.GET
import com.example.trasher.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface Connection {
    @GET("Auth")
    fun auth(@Query("password") password: Int,@Query("number") number: Int):User
    @GET("Cases/{id}")
    fun cases(@Path("id") id:Int):List<Case>
    @POST("Cases")
    fun set(@Field("title")String: String,@Field("description")description: String,@Field("id")id: Int):String
}
