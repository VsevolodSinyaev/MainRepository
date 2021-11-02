package com.vss3003.wallpapersearcher.data.Entity

import com.google.gson.annotations.SerializedName

data class ResultsDto(
    @SerializedName("offset")
    val response: Int,
    @SerializedName("limit")
    val results_for: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("results")
    val results: List<ComicHero>
)