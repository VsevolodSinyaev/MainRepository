package com.vss3003.wallpapersearcher.data

import com.google.gson.annotations.SerializedName

data class ComicList(
        @SerializedName("available")
        val available: Int,
        @SerializedName("returned")
        val returned: Int,
        @SerializedName("collectionURl")
        val collectionURl: String,
        @SerializedName("items")
        val items: List<ComicSummary>
)