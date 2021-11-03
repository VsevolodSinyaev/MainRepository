package com.vss3003.wallpapersearcher.view.rv_adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vss3003.wallpapersearcher.R
import com.vss3003.wallpapersearcher.domain.Heroes
import com.vss3003.wallpapersearcher.view.rv_viewholders.CharacterViewHolder
import kotlinx.android.synthetic.main.character_item.view.*

class CharacterListRecyclerAdapter(private val clickListener: OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = mutableListOf<Heroes>()

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CharacterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CharacterViewHolder -> {
                holder.bind(items[position])
                holder.itemView.item_container.setOnClickListener {
                    clickListener.click(items[position])

                }

            }

        }

    }

    fun addItems(mutableList: List<Heroes>) {
        items.clear()
        items.addAll(mutableList)
        notifyDataSetChanged()

    }

    interface OnItemClickListener {
        fun click(heroes: Heroes)

    }
}