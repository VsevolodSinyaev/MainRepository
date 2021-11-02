package com.vss3003.wallpapersearcher.domain

import com.vss3003.wallpapersearcher.data.ApiConstants
import com.vss3003.wallpapersearcher.data.Entity.ResultsDto
import com.vss3003.wallpapersearcher.data.HApi
import com.vss3003.wallpapersearcher.utils.Converter
import com.vss3003.wallpapersearcher.viewmodel.HeroViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*

class Interactor(private val retrofitService: HApi) {

    fun getHeroesFromApi(callback: HeroViewModel.ApiCallback) {
        retrofitService.getHeroes(1, ApiConstants.PUBLIC_API_KEY, ApiConstants.PRIVATE_API_KEY)
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

fun getHashMd5(publicKey: String, privateKey: String): String? {
    val dataStamp = Date().time.toString()
    val hash = "$dataStamp$privateKey$publicKey"
    var digest: ByteArray = byteArrayOf()
    try {
        val messageDigest = MessageDigest.getInstance("MD5")
        digest = messageDigest.digest(hash.toByteArray())
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }
    val md5Hex = BigInteger(1, digest)
            .toString(16)
            .let {
                if (it.length < 32) "0$it" else it
            }
    return md5Hex
}