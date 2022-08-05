package com.example.coininspect.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.coininspect.data.remote.dto.Team

class DiffTeamCallBack : DiffUtil.ItemCallback<Team>() {
    override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
        return oldItem.name == newItem.name && oldItem.position == newItem.position

    }
}