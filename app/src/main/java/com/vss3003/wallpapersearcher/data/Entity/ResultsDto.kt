package com.vss3003.wallpapersearcher.data.Entity


import com.google.gson.annotations.SerializedName

data class ResultsDto(
        @SerializedName("offset")
        val offset: Int,
        @SerializedName("limit")
        val limit: Int,
        @SerializedName("total")
        val total: Int,
        @SerializedName("count")
        val count: Int,
        @SerializedName("results")
        val results: List<MarvelCharacter>
)