package com.vss3003.wallpapersearcher.view.rv_viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vss3003.wallpapersearcher.data.ApiConstants
import com.vss3003.wallpapersearcher.domain.Hero
import kotlinx.android.synthetic.main.character_item.view.*

class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val name = itemView.name
    private val poster = itemView.poster
    private val description = itemView.description

    fun bind(hero: Hero) {
        name.text = hero.name
        Glide.with(poster.context)
                .load(ApiConstants.IMAGE_URL + hero.id + "/" + hero.image)
                .centerCrop().into(poster)
    }
}