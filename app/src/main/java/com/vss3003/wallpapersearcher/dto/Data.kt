package com.vss3003.wallpapersearcher.dto

data class Data(
        val count: Int,
        val limit: Int,
        val offset: Int,
        val results: List<Result>,
        val total: Int
)