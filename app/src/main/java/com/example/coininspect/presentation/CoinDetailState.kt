package com.example.coininspect.presentation

import androidx.lifecycle.MutableLiveData
import com.example.coininspect.domain.model.Coin
import com.example.coininspect.domain.model.CoinDetail

data class CoinDetailState(
    var isLoading: MutableLiveData<Boolean> = MutableLiveData(true),
    var coinDetail: CoinDetail? = null,
    var errMsg: String = ""
)
