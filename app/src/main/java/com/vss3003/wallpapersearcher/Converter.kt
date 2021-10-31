package com.vss3003.wallpapersearcher

import android.os.Build
import androidx.annotation.RequiresApi

object Converter {
    @RequiresApi(Build.VERSION_CODES.N)
    fun convertApiListToDTOList(mutableList: MutableList<MarvelCharacter>?): MutableList<Character> {
        val result: MutableList<Character> = mutableListOf()
        result.forEach {
            result.add(Character(
                id = it.id,
                name = it.name,
                poster = it.poster,
                description = it.description,
                isInFavorites = false
            ))
        }
        return result
    }
}