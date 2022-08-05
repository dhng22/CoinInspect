package com.example.coininspect.data.repository

import android.util.Log
import com.example.coininspect.data.remote.ApiRequest
import com.example.coininspect.data.remote.dto.CoinDetailDto
import com.example.coininspect.data.remote.dto.CoinDto
import com.example.coininspect.domain.repository.CoinRepository
import retrofit2.HttpException

class CoinRepositoryImpl(private val apiRequest: ApiRequest):CoinRepository {
    override fun getCoins(): List<CoinDto> {
        val response = apiRequest.getCoins.execute()
        if (response.code() != 200) {
            throw HttpException(response)
        }
        return apiRequest.getCoins.execute().body()!!
    }

    override fun getCoinById(id: String): CoinDetailDto {
        return apiRequest.getCoinById(id).execute().body()!!
    }
}