package com.vss3003.wallpapersearcher.utils

import com.vss3003.wallpapersearcher.data.Hero
import com.vss3003.wallpapersearcher.domain.Heroes

object Converter {
    fun convertApiListToDTOList(list: List<Hero>?): List<Heroes> {
        val result = mutableListOf<Heroes>()
        list?.forEach {
            result.add(
                    Heroes(
                            name = it.name,
                            thumbnail = "",
                            description = it.description,
                            id = it.id,
                            isInFavorites = false
                    )
            )
        }
        return result
    }
}