package com.vss3003.wallpapersearcher

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.character_item.view.*

//В конструктор класс передается layout, который мы создали(film_item.xml)
class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //Привязываем View из layout к переменным
    private val name = itemView.name
    private val poster = itemView.poster
    private val description = itemView.description

    //В этом методе кладем данные из Character в наши View
    fun bind(character: Character) {
        //Устанавливаем имя
        name.text = character.name
        //Устанавливаем постер
        Glide.with(poster.context)
                .load(ApiConstants.IMAGE_URL + character.id + "standard_medium")
                .centerCrop().into(poster)
        //Устанавливаем описание
        description.text = character.description
    }
}