package com.vss3003.wallpapersearcher.utils

import com.vss3003.wallpapersearcher.domain.Heroes
import com.vss3003.wallpapersearcher.dto.Result

object Converter {
    fun convertApiListToDTOList(list: List<Result>?): List<Heroes> {
        val result = mutableListOf<Heroes>()
        list?.forEach {
            // TODO: 03.11.2021 модель Heroes ваще не совпадает, поэтому только имя, описание и ID
            result.add(
                    Heroes(
                            name = it.name,
                            poster = "",
                            description = it.description,
                            id = it.id,
                            isInFavorites = false
                    )
            )
        }
        return result
    }
}