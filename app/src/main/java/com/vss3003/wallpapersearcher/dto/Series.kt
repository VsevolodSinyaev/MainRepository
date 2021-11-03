package com.vss3003.wallpapersearcher.dto

data class Series(
        val available: Int,
        val collectionURI: String,
        val items: List<ItemXX>,
        val returned: Int
)