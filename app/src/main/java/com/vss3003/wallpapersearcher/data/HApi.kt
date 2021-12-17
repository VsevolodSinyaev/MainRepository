package com.vss3003.wallpapersearcher.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HApi {
    @GET("v1/public/characters")
    fun getHeroes(
            @Query("apikey") apiKey: String,
            @Query("ts") timeStamp: String,
            @Query("hash") hash: String
    ): Call<HeroDataWrapper>
}