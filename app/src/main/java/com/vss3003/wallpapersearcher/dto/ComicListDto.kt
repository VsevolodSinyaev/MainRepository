package com.vss3003.wallpapersearcher.dto

data class ComicListDto(
        val available: Int,
        val returned: Int,
        val collectionURI: String,
        val comicSummaryDtos: List<ComicSummaryDto>
)