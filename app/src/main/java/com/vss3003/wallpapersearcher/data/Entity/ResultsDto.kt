package com.vss3003.wallpapersearcher.data.Entity

import com.google.gson.annotations.SerializedName

data class ResultsDto(
    @SerializedName("response")
    val response: String,
    @SerializedName("results_for")
    val results_for: String,
    @SerializedName("results")
    val results: List<ComicHero>
)