package com.vss3003.wallpapersearcher.dto

import com.google.gson.annotations.SerializedName

data class Thumbnail(
        @SerializedName("path")
        val path: String,
        @SerializedName("extension")
        val extension: String
)