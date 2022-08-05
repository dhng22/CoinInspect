package com.example.coininspect.data.di

import android.app.Application
import com.example.coininspect.common.Constants
import com.example.coininspect.data.remote.ApiRequest
import com.example.coininspect.data.repository.CoinRepositoryImpl
import com.example.coininspect.domain.repository.CoinRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppMod : Application() {

    fun provideApi(): ApiRequest {
        return Retrofit.Builder().baseUrl(Constants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiRequest::class.java)

    }
    fun provideCoinRepository(apiRequest: ApiRequest):CoinRepository{
        return CoinRepositoryImpl(apiRequest)
    }
}