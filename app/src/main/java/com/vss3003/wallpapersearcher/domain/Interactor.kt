package com.vss3003.wallpapersearcher.domain

import com.vss3003.wallpapersearcher.data.ApiConstants
import com.vss3003.wallpapersearcher.data.Entity.ResultsDto
import com.vss3003.wallpapersearcher.data.HApi
import com.vss3003.wallpapersearcher.utils.Converter
import com.vss3003.wallpapersearcher.viewmodel.HeroViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Interactor(private val retrofitService: HApi) {

    fun getHeroesFromApi(callback: HeroViewModel.ApiCallback) {
        retrofitService.getHeroes(ApiConstants.ACCESS_TOKEN)
                .enqueue(object : Callback<ResultsDto> {
                    override fun onResponse(call: Call<ResultsDto>, response: Response<ResultsDto>) {
                        callback.onSuccess(
                                Converter.convertApiListToDTOList(
                                        response.body()?.results
                                )
                        )
                    }

                    override fun onFailure(call: Call<ResultsDto>, t: Throwable) {
                        callback.onFailure()
                    }
                })
    }
}