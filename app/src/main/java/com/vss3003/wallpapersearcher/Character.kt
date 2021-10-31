package com.vss3003.wallpapersearcher

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character(
    val name: String,
    val id: Int,
    val poster: String,
    val description: String,
    var isInFavorites: Boolean = false
) : Parcelable