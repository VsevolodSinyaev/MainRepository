package com.vss3003.wallpapersearcher.dto

data class HeroDataWrapperDto(
        val code:Int,
        val status:String,
        val copyright:String,
        val attributionText:String,
        val attributionHTML:String,
        val etag:String,
        val data:HeroDataContainerDto
)