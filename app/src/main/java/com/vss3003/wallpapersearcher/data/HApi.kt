package com.vss3003.wallpapersearcher.data

import com.vss3003.wallpapersearcher.data.Entity.ResultsDto
import com.vss3003.wallpapersearcher.domain.getHashMd5
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HApi {
    @GET(ApiConstants.BASE_URL + "v1/public//characters?" + getHashMd5("a4e1e4a509ee56b1b7b70563ff828b8a", "7062eecf293fe8afba70994ab54fe0adb545068c")
    fun getHeroes(
            @Query("api_key") api_key: String,
            @Query("ts") ts: String,
            @Query("hash") hash: String,
    ): Call<ResultsDto>
}
//"apikey=7062eecf293fe8afba70994ab54fe0adb545068c&ts={{todayDate}}&hash={{hashMd}}/"