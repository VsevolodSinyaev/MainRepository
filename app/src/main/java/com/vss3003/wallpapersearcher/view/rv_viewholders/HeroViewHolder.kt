package com.vss3003.wallpapersearcher.view.rv_viewholders

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vss3003.wallpapersearcher.domain.Heroes
import com.vss3003.wallpapersearcher.dto.ThumbnailDto
import kotlinx.android.synthetic.main.character_item.view.*
import java.nio.file.Paths.get

class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val name = itemView.name
    private val poster = itemView.poster
    private val description = itemView.description
    private lateinit var thumbnailDto: ThumbnailDto

    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(heroes: Heroes) {
        thumbnailDto = get("thumbnail") as ThumbnailDto
        name.text = heroes.name
        Glide.with(poster.context)
                .load(thumbnailDto.path + "standard_small." + thumbnailDto.extension)
                .centerCrop().into(poster)
        description.text = heroes.description
    }
}