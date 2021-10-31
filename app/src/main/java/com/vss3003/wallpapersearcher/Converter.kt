package com.vss3003.wallpapersearcher

object Converter {
    fun convertApiListToDTOList(list: List<MarvelCharacter>?): List<Character> {
        val result = mutableListOf<Character>()
        list?.forEach {
            result.add(Character(
                name = it.name,
                poster = it.posterPath,
                description = it.description,
                id = it.id,
                isInFavorites = false
            ))
        }
        return result
    }
}