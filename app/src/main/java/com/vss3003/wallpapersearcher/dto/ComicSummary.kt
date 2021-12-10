package com.vss3003.wallpapersearcher.dto

import com.google.gson.annotations.SerializedName

data class ComicSummary(
        @SerializedName("resourceURl")
        val resourceURl: String,
        @SerializedName("name")
        val name: String
)