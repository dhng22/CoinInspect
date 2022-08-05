package com.example.coininspect.presentation.view_model

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coininspect.common.Resource
import com.example.coininspect.data.remote.dto.Tag
import com.example.coininspect.data.remote.dto.Team
import com.example.coininspect.domain.model.CoinDetail
import com.example.coininspect.domain.use_cases.GetCoinDetailUseCase
import com.example.coininspect.domain.use_cases.GetCoinUseCase
import com.example.coininspect.presentation.CoinDetailState
import com.example.coininspect.presentation.CoinListState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoinDetailViewModel() : ViewModel() {
    lateinit var browseOnClick:(Intent) -> Unit
    lateinit var teamAdapter: ListAdapter<Team, RecyclerView.ViewHolder>
    lateinit var coinDetailUseCase: GetCoinDetailUseCase
    lateinit var tagAdapter: ListAdapter<Tag, RecyclerView.ViewHolder>

    companion object {
        val coinsData = CoinDetailState()
    }

    fun getCoin(id: String): Unit {
        viewModelScope.launch(Dispatchers.IO) {
            coinDetailUseCase(id).collect { result ->
                when (result) {
                    is Resource.Error -> coinsData.apply {
                        withContext(Dispatchers.Main) {
                            errMsg = result.message!!
                            coinDetail = null
                            isLoading.postValue(false)
                            Log.e("TAG", "err ");
                        }
                    }
                    is Resource.Loading -> coinsData.apply {
                        withContext(Dispatchers.Main) {
                            isLoading.postValue(true)
                            Log.e("TAG", "loading, value posted ");
                        }
                    }
                    is Resource.Success -> coinsData.apply {
                        withContext(Dispatchers.Main) {
                            coinDetail = result.value!!
                            isLoading.postValue(false)
                            Log.e("TAG", "success, value posted ");
                        }
                    }
                }
            }
        }
    }

    fun browseURL(url: String): Unit {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        browseOnClick.invoke(intent)
    }
}