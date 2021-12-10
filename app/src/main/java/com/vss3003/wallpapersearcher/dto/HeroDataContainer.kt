package com.vss3003.wallpapersearcher.dto

import com.google.gson.annotations.SerializedName

data class HeroDataContainer(
        @SerializedName("offset")
        val offset: Int,
        @SerializedName("limit")
        val limit: Int,
        @SerializedName("total")
        val total: Int,
        @SerializedName("count")
        val count: Int,
        @SerializedName("results")
        val results: List<Hero>
)