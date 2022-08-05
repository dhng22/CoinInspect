package com.example.coininspect.presentation


import androidx.recyclerview.widget.DiffUtil
import com.example.coininspect.data.remote.dto.Tag

class DiffTagCallBack : DiffUtil.ItemCallback<Tag>() {
    override fun areItemsTheSame(oldItem: Tag, newItem: Tag): Boolean {
        return oldItem.id.contentEquals(newItem.id)
    }

    override fun areContentsTheSame(oldItem: Tag, newItem: Tag): Boolean {
        return oldItem.name == newItem.name && oldItem.ico_counter == newItem.ico_counter
    }
}