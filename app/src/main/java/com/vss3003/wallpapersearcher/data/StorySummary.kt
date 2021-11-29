package com.vss3003.wallpapersearcher.data

import com.google.gson.annotations.SerializedName

data class StorySummary(
        @SerializedName("resourceURl")
        val resourceURl: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("type")
        val type: String,
)