package com.vss3003.wallpapersearcher

import android.media.Image
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.sql.Array
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

interface MarvelCharacterApi {
    @GET("v1/public/characters?apikey=a4e1e4a509ee56b1b7b70563ff828b8a")
    fun getCharacters(
        @Query("api_key") apiKey: String,
        @Query("weight") weight: Float,
        @Query("foodCategory") foodCategory: String,
    ):Call<ResultsDto>
}

object ApiConstants {
    const val BASE_URL = "https://gateway.marvel.com:443/"
    const val IMAGE_URL = "https://www.edamam.com/web-img/"
}

data class ResultsDto(
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("count")
    val count: Int,
    @SerializedName("results")
    val results: List<MarvelCharacter>
)

data class MarvelCharacter(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("modified")
    val modified: Date,
    @SerializedName("resourceURI")
    val resourceURI: String,
    @SerializedName("urls")
    val urls: Array,
    @SerializedName("thumbnail")
    val thumbnail: Image,
    @SerializedName("thumbnail_path")
    val thumbnail_path: String
)
