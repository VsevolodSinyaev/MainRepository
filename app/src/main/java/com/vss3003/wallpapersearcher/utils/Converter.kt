package com.vss3003.wallpapersearcher.utils

import com.vss3003.wallpapersearcher.domain.Heroes
import com.vss3003.wallpapersearcher.dto.HeroDto

object Converter {
    fun convertApiListToDTOList(list: List<HeroDto>?): List<Heroes> {
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