package com.vss3003.wallpapersearcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val character = intent.extras?.get("character") as Character

        details_toolbar.title = character.name
        Glide.with(this)
                .load(ApiConstants.IMAGE_URL + character.id + "standard_medium")
                .centerCrop()
                .into(detailsPoster)
        details_description.text = character.description

    }
}


