package com.vss3003.wallpapersearcher

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.character_item.view.*

class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val name = itemView.name
    private val poster = itemView.poster
    private val description = itemView.description

    fun bind(hero: Hero) {
        name.text = hero.name
        Glide.with(poster.context)
                .load(ApiConstants.IMAGE_URL + hero.id + "standard_medium")
                .centerCrop().into(poster)
        description.text = hero.description
    }
}