package com.example.coininspect.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coininspect.data.remote.dto.Team
import com.example.coininspect.databinding.RowTeamMemberBinding
import com.example.coininspect.presentation.DiffTeamCallBack

class TeamListAdapter : ListAdapter<Team, RecyclerView.ViewHolder>(DiffTeamCallBack()) {
    class TeamHolder(val binding: RowTeamMemberBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(team: Team): Unit {
            binding.team= team
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TeamHolder(RowTeamMemberBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TeamHolder).onBind(getItem(position))
    }
}