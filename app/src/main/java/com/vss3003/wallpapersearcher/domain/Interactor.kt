package com.vss3003.wallpapersearcher.domain

import android.util.Log
import com.vss3003.wallpapersearcher.data.ApiConstants
import com.vss3003.wallpapersearcher.data.ApiConstants.API_KEY_PUBLIC
import com.vss3003.wallpapersearcher.data.HApi
import com.vss3003.wallpapersearcher.dto.HeroDataWrapperDto
import com.vss3003.wallpapersearcher.utils.Converter
import com.vss3003.wallpapersearcher.viewmodel.HomeFragmentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*


class Interactor(private val retrofitService: HApi) {

    fun getHeroesFromApi(page: Int, callback: HomeFragmentViewModel.ApiCallback) {
        retrofitService.getHeroes(
            API_KEY_PUBLIC,
            getTimeStump(),
            getHashMd5(API_KEY_PUBLIC, ApiConstants.API_KEY_PRIVATE)
        ).enqueue(object : Callback<HeroDataWrapperDto> {
            override fun onResponse(call: Call<HeroDataWrapperDto>, response: Response<HeroDataWrapperDto>) {
                callback.onSuccess(
                    Converter.convertApiListToDTOList(
                        response.body()?.data?.results
                    )
                )
                Log.d("TAG", "response: ${response.body()?.data?.results}")
            }

            override fun onFailure(call: Call<HeroDataWrapperDto>, t: Throwable) {
                callback.onFailure()
            }
        })
    }

    private fun getTimeStump(): String {
        return Date().time.toString()
    }

    //хеширование
    private fun getHashMd5(publicKey: String, privateKey: String): String {
        val dataStamp = Date().time.toString()
        val hash = "$dataStamp$privateKey$publicKey"
        var digest: ByteArray = byteArrayOf()
        try {
            val messageDigest = MessageDigest.getInstance("MD5")
            digest = messageDigest.digest(hash.toByteArray())
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return BigInteger(1, digest)
                .toString(16)
                .let {
                    if (it.length < 32) "0$it" else it
                }
    }
}