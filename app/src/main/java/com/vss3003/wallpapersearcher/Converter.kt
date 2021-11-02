package com.vss3003.wallpapersearcher

object Converter {
    fun convertApiListToDTOList(list: List<MarvelHero>?): List<Hero> {
        val result = mutableListOf<Hero>()
        list?.forEach {
            result.add(Hero(
                name = it.name,
                image = it.posterPath,
                description = it.description,
                id = it.id,
                isInFavorites = false
            ))
        }
        return result
    }
}