package com.example.trasher.API

import android.graphics.Bitmap
import android.os.Parcelable
import com.example.trasher.Case
import com.example.trasher.User
import kotlinx.android.parcel.Parcelize
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface Connection {
    @GET("Auth")
    fun auth(@Query("password") password: Int,@Query("number") number: Int): User
    @GET("Cases/{id}")
    fun cases(@Path("id") id:Int):List<Case>

    @POST("Cases")
    fun set(@Query("title")title: String,@Query("description")description: String,@Query("user_id")id: Int):String

//    @POST("Cases")
//    fun set(@Body title: Add):String

//    @FormUrlEncoded
//    @POST("Cases")
//    fun set(@Field("title")title: String,@Field("description")description: String,@Field("user_id")id: Int):String

}
@Parcelize
data class Add(
    val id: Int,
    val title: String?,
    val description: String?
): Parcelable