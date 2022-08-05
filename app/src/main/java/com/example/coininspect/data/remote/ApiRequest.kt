package com.example.coininspect.data.remote

import com.example.coininspect.common.Constants
import com.example.coininspect.data.remote.dto.CoinDetailDto
import com.example.coininspect.data.remote.dto.CoinDto
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRequest {
    @get:GET("coins")
    val getCoins: Call<List<CoinDto>>

    @GET("coins/{id}")
    fun getCoinById(@Path("id")id:String):Call<CoinDetailDto>
}