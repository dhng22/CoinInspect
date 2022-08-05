package com.example.coininspect.domain.model

import com.example.coininspect.data.remote.dto.*
import com.google.gson.annotations.SerializedName

class CoinDetail(
    val description: String,
    val developmentStatus: String?,
    val id: String,
    val isActive: Boolean,
    val links: Links?,
    val linksExtended: List<LinksExtended>?,
    val message: String?,
    val name: String,
    val openSource: Boolean,
    val rank: Int,
    val symbol: String,
    val tags: List<Tag>?,
    val team: List<Team>?,
    val type: String
) {
}