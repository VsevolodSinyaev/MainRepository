package com.vss3003.wallpapersearcher.view.rv_viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vss3003.wallpapersearcher.data.ApiConstants
import com.vss3003.wallpapersearcher.domain.Heroes
import kotlinx.android.synthetic.main.character_item.view.*

class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val name = itemView.name
    private val thumbnail = itemView.thumbnail
    private val description = itemView.description

    fun bind(heroes: Heroes) {
        name.text = heroes.name
        Glide.with(thumbnail.context)
                .load(ApiConstants.IMAGE_URL)
                .centerCrop()
                .into(thumbnail)
        description.text = heroes.description
    }
}