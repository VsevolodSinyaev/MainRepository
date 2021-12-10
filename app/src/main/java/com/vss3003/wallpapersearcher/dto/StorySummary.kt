package com.vss3003.wallpapersearcher.dto

import com.google.gson.annotations.SerializedName

data class StorySummary(
        @SerializedName("resourceURI")
        val resourceURI: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("type")
        val type: String,
)