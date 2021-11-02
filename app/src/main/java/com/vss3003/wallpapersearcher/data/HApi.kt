package com.vss3003.wallpapersearcher.data

import com.vss3003.wallpapersearcher.data.Entity.ResultsDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HApi {
    @GET("/characters")
    fun getHeroes(
        @Query("access_token") access_token: String
    ): Call<ResultsDto>
}
