package com.vss3003.wallpapersearcher


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.character_item.view.*

class HeroListRecyclerAdapter(private val clickListener: OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = mutableListOf<Hero>()

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HeroViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeroViewHolder -> {
                holder.bind(items[position])
                holder.itemView.item_container.setOnClickListener {
                    clickListener.click(items[position])

                }

            }

        }

    }

    fun addItems(mutableList: List<Hero>) {
        items.clear()
        items.addAll(mutableList)
        notifyDataSetChanged()

    }

    interface OnItemClickListener {
        fun click(hero: Hero)

    }
}