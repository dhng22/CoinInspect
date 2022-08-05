package com.example.coininspect.presentation

import androidx.lifecycle.MutableLiveData
import com.example.coininspect.domain.model.Coin

data class CoinListState(
    var isLoading: MutableLiveData<Boolean> = MutableLiveData(true),
    var coinList: List<Coin> = emptyList(),
    var errMsg:String=""
)