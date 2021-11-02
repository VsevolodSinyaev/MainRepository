package com.vss3003.wallpapersearcher.utils

import com.vss3003.wallpapersearcher.data.Entity.ComicHero
import com.vss3003.wallpapersearcher.domain.Hero

object Converter {
    fun convertApiListToDTOList(list: List<ComicHero>?): List<Hero> {
        val result = mutableListOf<Hero>()
        list?.forEach {
            result.add(Hero(
                name = it.name,
                image = it.image,
                id = it.id,
                isInFavorites = false
            ))
        }
        return result
    }
}