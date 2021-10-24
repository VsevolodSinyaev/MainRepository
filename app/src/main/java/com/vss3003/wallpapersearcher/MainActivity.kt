package com.vss3003.wallpapersearcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.http.GET
import retrofit2.http.Query


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

interface RecipesApi {
    @GET("https://api.edamam.com/api/recipes/v2")
    fun getRecipes(
        @Query("api_key") apiKey: String,
        @Query("weight") weight: Float,
        @Query("foodCategory") foodCategory: String,
    )
}

object ApiConstants {
    const val BASE_URL = "https://api.edamam.com/api/recipes/v2"
    const val IMAGE_URL = "https://www.edamam.com/web-img/"
}

