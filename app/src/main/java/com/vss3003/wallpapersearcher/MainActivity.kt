package com.vss3003.wallpapersearcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.http.GET
import retrofit2.http.Query

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

interface WallhavenApi {
    @GET("https://www.googleapis.com/books/v1/volumes?q=flowers&orderBy=toplist&key=LAq8Y9XtyC3vD5HH7AVjzzQUi4TZE8pG")
    fun getWallpapers(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int,
        @Query("category") category: String,
    )
}

