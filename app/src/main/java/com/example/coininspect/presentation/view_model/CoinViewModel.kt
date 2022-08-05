package com.example.coininspect.presentation.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coininspect.common.Resource
import com.example.coininspect.domain.model.Coin
import com.example.coininspect.domain.use_cases.GetCoinUseCase
import com.example.coininspect.presentation.CoinListState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoinViewModel() : ViewModel() {
    lateinit var coinListAdapter: ListAdapter<Coin, RecyclerView.ViewHolder>
    lateinit var coinUseCase: GetCoinUseCase
    companion object{
        val coinsData = CoinListState()
    }

    fun getCoin(): Unit {
        viewModelScope.launch(Dispatchers.IO) {
            coinUseCase().collect { result ->
                when (result) {
                    is Resource.Error -> coinsData.apply {
                        withContext(Dispatchers.Main) {
                            errMsg = result.message!!
                            coinList = emptyList()
                            isLoading.postValue(false)
                            Log.e("TAG", "err ");
                        }
                    }
                    is Resource.Loading -> coinsData.apply {
                        withContext(Dispatchers.Main) {
                            isLoading.postValue(true)
                            Log.e("TAG", "loading ");
                        }
                    }
                    is Resource.Success -> coinsData.apply {
                        withContext(Dispatchers.Main) {
                            coinList = result.value!!
                            isLoading.postValue(false)
                            Log.e("TAG", "success ");
                        }
                    }
                }
            }
        }
    }
}