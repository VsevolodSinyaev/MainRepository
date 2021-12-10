package com.vss3003.wallpapersearcher.dto

import com.google.gson.annotations.SerializedName

data class Url(
        @SerializedName("type")
        val type: String,
        @SerializedName("url")
        val url: String
)