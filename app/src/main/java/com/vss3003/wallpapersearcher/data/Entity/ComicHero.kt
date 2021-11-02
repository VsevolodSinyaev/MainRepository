package com.vss3003.wallpapersearcher.data.Entity

import android.media.Image
import com.google.gson.annotations.SerializedName
import java.sql.Array
import java.util.*

data class ComicHero(
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
    @SerializedName("poster")
    val poster: Image,
    @SerializedName("posterPath")
    val posterPath: String,
    @SerializedName("comics")
    val comics: Array,
    @SerializedName("stories")
    val stories: Array,
    @SerializedName("events")
    val events: Array,
    @SerializedName("series")
    val series: Array
)