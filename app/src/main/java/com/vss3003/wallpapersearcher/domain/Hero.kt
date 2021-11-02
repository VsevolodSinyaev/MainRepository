package com.vss3003.wallpapersearcher.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hero(
    val name: String,
    val id: Int,
    val posterPath: String,
    var isInFavorites: Boolean = false
) : Parcelable