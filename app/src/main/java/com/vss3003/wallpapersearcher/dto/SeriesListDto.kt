package com.vss3003.wallpapersearcher.dto

data class SeriesListDto(
        val availableDto: Int,
        val returnedDto: Int,
        val collectionURlDto: String,
        val itemsDto: List<SeriesSummaryDto>
)