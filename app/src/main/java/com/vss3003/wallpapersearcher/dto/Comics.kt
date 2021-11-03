package com.vss3003.wallpapersearcher.dto

data class Comics(
        val available: Int,
        val collectionURI: String,
        val items: List<Item>,
        val returned: Int
)