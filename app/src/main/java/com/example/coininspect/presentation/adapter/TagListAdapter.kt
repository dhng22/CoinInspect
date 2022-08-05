package com.example.coininspect.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coininspect.data.remote.dto.Tag
import com.example.coininspect.databinding.ItemTagBinding
import com.example.coininspect.presentation.DiffTagCallBack

class TagListAdapter() : ListAdapter<Tag, RecyclerView.ViewHolder>(DiffTagCallBack()) {
    class TagHolder(val binding: ItemTagBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(tag: Tag): Unit {
            binding.tag = tag
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TagHolder(ItemTagBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TagHolder).onBind(getItem(position))
    }
}