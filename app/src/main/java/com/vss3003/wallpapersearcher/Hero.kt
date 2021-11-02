package com.vss3003.wallpapersearcher

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hero(
    val name: String,
    val id: Int,
    val image: String,
    val description: String,
    var isInFavorites: Boolean = false
) : Parcelable