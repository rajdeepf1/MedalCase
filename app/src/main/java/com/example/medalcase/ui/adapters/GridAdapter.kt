package com.example.medalcase.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.medalcase.R
import com.example.medalcase.data.models.MedalListModel
import com.example.medalcase.data.models.MedalModel
import com.example.medalcase.databinding.ItemGridBinding
import com.example.medalcase.databinding.ItemSectionHeaderBinding
import com.example.medalcase.utils.Utils
import com.example.medalcase.utils.Utils.showToast

class GridAdapter(private val sections: List<MedalModel>, private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
        val itemGridBinding =
            ItemGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val sectionHeaderBinding =
            ItemSectionHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return when (viewType) {
            VIEW_TYPE_HEADER -> SectionHeaderViewHolder(
                view = sectionHeaderBinding.root
            )

            VIEW_TYPE_ITEM -> ItemViewHolder(
                view = itemGridBinding.root
            )

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is String -> (holder as SectionHeaderViewHolder).bind(item)
            is MedalListModel -> (holder as ItemViewHolder).bind(item, context, holder.itemView)
        }
    }

    override fun getItemCount(): Int = items.size
}

class SectionHeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val headerTitle = view.findViewById<TextView>(R.id.headerTitle)
    private val headerTextOutOf = view.findViewById<TextView>(R.id.headerTextOutOf)

    fun bind(header: String) {
        headerTitle.text = header
        if (header == "Personal Records") {
            headerTextOutOf.visibility == View.VISIBLE
            headerTextOutOf.text = "4 of 6"
        } else {
            headerTextOutOf.visibility = View.INVISIBLE
        }
    }
}

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val itemTitle = view.findViewById<TextView>(R.id.itemTitle)
    private val itemImage = view.findViewById<ImageView>(R.id.itemImage)
    private val itemSubTitle = view.findViewById<TextView>(R.id.itemSubTitle)
    private val ll_gridItems = view.findViewById<LinearLayout>(R.id.ll_gridItems)
    fun bind(item: MedalListModel, context: Context, view: View) {
        itemTitle.text = item.title
        itemImage.setImageResource(item.image)
        itemSubTitle.text = item.subTitle
        if (!item.isActive) {
            ll_gridItems.alpha = 0.4f
            ll_gridItems.isEnabled = false
        }
        ll_gridItems.setOnClickListener {
            showToast(context, "${item.title} Clicked!", Toast.LENGTH_SHORT)
            Utils.flipView(view = view)
        }
    }
}