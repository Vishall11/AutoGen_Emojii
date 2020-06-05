package com.example.autogenemojii.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.autogenemojii.R
import com.example.autogenemojii.dataclass.RecyclerViewItems
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class Adapter(private val emojiList: List<RecyclerViewItems>?): RecyclerView.Adapter<Adapter.EmojiViewHolder>() {

    override fun getItemCount() = (emojiList?.size) ?: 0

    override fun onBindViewHolder(holder: EmojiViewHolder, position: Int) {
        val currentItem = emojiList?.get(position)


        if (currentItem != null) {
            holder.emojiText.text = currentItem.todoTask
            holder.emojiImg.setImageResource(currentItem.emojiImageResource)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmojiViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item,parent,false)

        return EmojiViewHolder(itemView)
    }

    class EmojiViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val emojiText: TextView = itemView.listNameTextView
        val emojiImg: ImageView = itemView.emojiImageView
    }
}