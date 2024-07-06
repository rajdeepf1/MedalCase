package com.example.medalcase.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.medalcase.data.models.MedalListModel
import com.example.medalcase.data.models.MedalModel

class GridAdapter(private val sections: List<MedalModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_HEADER = 0
        const val VIEW_TYPE_ITEM = 1
    }

    private val items: List<Any> = sections.flatMap { listOf(it.heading) + it.medalListModel }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is String -> VIEW_TYPE_HEADER
            is MedalListModel -> VIEW_TYPE_ITEM
            else -> throw IllegalArgumentException("Invalid type of data $position")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_HEADER -> SectionHeaderViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_section_header, parent, false)
            )
            VIEW_TYPE_ITEM -> ItemViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent, false)
            )
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is String -> (holder as SectionHeaderViewHolder).bind(item)
            is MedalListModel -> (holder as ItemViewHolder).bind(item)
        }
    }

    override fun getItemCount(): Int = items.size
}

class SectionHeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val headerTitle = view.findViewById<TextView>(R.id.headerTitle)

    fun bind(header: String) {
        headerTitle.text = header
    }
}

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val itemTitle = view.findViewById<TextView>(R.id.itemTitle)
    private val itemImage = view.findViewById<ImageView>(R.id.itemImage)

    fun bind(item: MedalListModel) {
        itemTitle.text = item.title
        // Load the image using Glide
        itemImage.setImageResource(item.image)
    }
}