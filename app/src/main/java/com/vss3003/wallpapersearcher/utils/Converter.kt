package com.vss3003.wallpapersearcher.utils

import com.vss3003.wallpapersearcher.domain.Heroes
import com.vss3003.wallpapersearcher.dto.Result

object Converter {
    fun convertApiListToDTOList(mutableList: MutableList<Result>?): MutableList<Heroes> {
        val result = mutableListOf<Heroes>()
        mutableList?.forEach {
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