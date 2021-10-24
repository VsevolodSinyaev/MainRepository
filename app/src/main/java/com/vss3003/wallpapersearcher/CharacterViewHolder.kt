package com.vss3003.wallpapersearcher

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.character_item.view.*

//В конструктор класс передается layout, который мы создали(character_item.xml)
class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val name = itemView.name
    private val description = itemView.description

    fun bind(character: Character) {
        name.text = character.name
        description.text = character.description

    }

}