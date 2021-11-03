package com.vss3003.wallpapersearcher.view.rv_viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vss3003.wallpapersearcher.data.ApiConstants
import com.vss3003.wallpapersearcher.domain.Heroes
import kotlinx.android.synthetic.main.character_item.view.*

class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val name = itemView.name
    private val poster = itemView.poster
    private val description = itemView.description

    fun bind(heroes: Heroes) {
        name.text = heroes.name
        Glide.with(poster.context)
                .load(ApiConstants.IMAGE_URL + heroes.id + "standard_medium")
                .centerCrop().into(poster)
        description.text = heroes.description
    }
}