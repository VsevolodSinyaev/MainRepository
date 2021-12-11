package com.vss3003.wallpapersearcher.view.rv_viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vss3003.wallpapersearcher.domain.Heroes
import com.vss3003.wallpapersearcher.dto.Thumbnail
import kotlinx.android.synthetic.main.character_item.view.*

class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val name = itemView.name
    private val thumbnail = itemView.thumbnail
    private val description = itemView.description
    private lateinit var binding: Thumbnail

    fun bind(heroes: Heroes) {
        name.text = heroes.name
        Glide.with(thumbnail.context)
                .load(binding.path + "standard_small." + binding.extension)
                .centerCrop()
                .into(thumbnail)
        description.text = heroes.description
    }
}