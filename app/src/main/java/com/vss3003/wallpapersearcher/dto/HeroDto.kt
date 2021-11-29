package com.vss3003.wallpapersearcher.dto

import java.sql.Date

data class HeroDto(
    val id: Int,
    val name: String,
    val description: String,
    val modified: Date,
    val resourceURI: String,
    val url: List<UrlDto>,
    val thumbnailDto: ThumbnailDto,
    val comics: ComicListDto,
    val stories: StoryListDto,
    val events: EventListDto,
    val series: SeriesListDto
)