package com.vss3003.wallpapersearcher.data

import com.google.gson.annotations.SerializedName

data class EventSummary(
        @SerializedName("resourceURl")
        val resourceURl: String,
        @SerializedName("name")
        val name: String
)