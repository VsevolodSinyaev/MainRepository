package com.vss3003.wallpapersearcher

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CApi {
    @GET("v1/public/characters?apikey=a4e1e4a509ee56b1b7b70563ff828b8a")
    fun getCharacters(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Call<ResultsDto>
}