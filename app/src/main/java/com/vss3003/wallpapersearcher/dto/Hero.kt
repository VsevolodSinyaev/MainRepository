package com.vss3003.wallpapersearcher.dto

import com.google.gson.annotations.SerializedName

data class Hero(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("resourceURl")
    val resourceURI: Url,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail,
    @SerializedName("comics")
    val comics: ComicList,
    @SerializedName("stories")
    val stories: StoryList,
    @SerializedName("events")
    val events: EventList,
    @SerializedName("series")
    val series: SeriesList
)