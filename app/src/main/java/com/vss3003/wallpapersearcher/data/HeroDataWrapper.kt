package com.vss3003.wallpapersearcher.data

import com.google.gson.annotations.SerializedName

data class HeroDataWrapper(
        @SerializedName("code")
        val code: Int,
        @SerializedName("status")
        val status: String,
        @SerializedName("copyright")
        val copyright: String,
        @SerializedName("attributionText")
        val attributionText: String,
        @SerializedName("attributionHTML")
        val attributionHTML: String,
        @SerializedName("data")
        val data: HeroDataContainer,
        @SerializedName("etag")
        val etag: String
)