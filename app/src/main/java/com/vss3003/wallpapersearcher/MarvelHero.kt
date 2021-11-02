package com.vss3003.wallpapersearcher

import android.widget.ImageView
import com.google.gson.annotations.SerializedName
import java.sql.Array
import java.util.*

data class MarvelHero(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("modified")
    val modified: Date,
    @SerializedName("resourceURI")
    val resourceURI: String,
    @SerializedName("urls")
    val urls: Array,
    @SerializedName("posterPath")
    val posterPath: String,
    @SerializedName("poster")
    val poster: ImageView
)