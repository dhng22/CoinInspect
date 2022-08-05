package com.example.coininspect.domain.repository

import com.example.coininspect.data.remote.dto.CoinDetailDto
import com.example.coininspect.data.remote.dto.CoinDto

interface CoinRepository {
    fun getCoins(): List<CoinDto>
    fun getCoinById(id: String): CoinDetailDto
}