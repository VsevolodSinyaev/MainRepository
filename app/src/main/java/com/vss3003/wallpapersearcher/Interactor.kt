package com.vss3003.wallpapersearcher

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Interactor(private val retrofitService: HApi) {

    fun getHeroesFromApi(page: Int, callback: HeroViewModel.ApiCallback) {
        retrofitService.getHeroes(page)
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