package com.vss3003.wallpapersearcher

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HApi {
    @GET("/characters")
    fun getHeroes(
        @Query("page") page: Int
    ): Call<ResultsDto>
}
