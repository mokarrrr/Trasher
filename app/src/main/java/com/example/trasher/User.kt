package com.example.trasher

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: Int,
     val name: String?,
     val surname: String?,
     val password: Int?
     ): Parcelable{

}