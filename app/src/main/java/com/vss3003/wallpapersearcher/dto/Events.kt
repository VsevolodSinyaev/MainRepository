package com.vss3003.wallpapersearcher.dto

data class Events(
        val available: Int,
        val collectionURI: String,
        val items: List<ItemX>,
        val returned: Int
)