package com.example.coininspect.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.coininspect.domain.model.Coin

class DiffCoinCallBack : DiffUtil.ItemCallback<Coin>() {
    override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean {
        return oldItem.id == oldItem.id
    }

    override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean {
        return oldItem.name == newItem.name && oldItem.symbol == newItem.symbol
    }
}