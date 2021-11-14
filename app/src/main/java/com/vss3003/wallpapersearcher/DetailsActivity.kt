package com.vss3003.wallpapersearcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.vss3003.wallpapersearcher.domain.Heroes
import com.vss3003.wallpapersearcher.dto.Thumbnail
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val hero = intent.extras?.get("hero") as Heroes
        val thumbnail = intent.extras?.get("thumbnail") as Thumbnail

        details_toolbar.title = hero.name
        Glide.with(this)
                .load(thumbnail.path + "standard_small." + thumbnail.extension)
                .centerCrop()
                .into(detailsPoster)
        details_description.text = hero.description

    }

}
