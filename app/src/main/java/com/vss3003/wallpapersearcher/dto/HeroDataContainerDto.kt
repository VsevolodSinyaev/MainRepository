package com.vss3003.wallpapersearcher.dto

data class HeroDataContainerDto(
        val count: Int,
        val limit: Int,
        val offset: Int,
        val total: Int,
        val results: List<HeroDto>
)