package com.example.trasher

import android.graphics.Bitmap
import android.media.Image
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Case(
    val id: Int,
    val title: String?,
    val description: String?,
    val photo: String?,
    var evidence: ArrayList<String>?,
    var sketch: ArrayList<Bitmap>?,
    var notes: String?,
): Parcelable