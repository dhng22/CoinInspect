package com.example.coininspect.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.coininspect.R
import com.example.coininspect.data.di.AppMod
import com.example.coininspect.databinding.ActivityMainBinding
import com.example.coininspect.domain.use_cases.GetCoinDetailUseCase
import com.example.coininspect.presentation.adapter.CoinListAdapter
import com.example.coininspect.presentation.view_model.CoinDetailViewModel
import com.example.coininspect.presentation.view_model.CoinViewModel

class MainActivity : AppCompatActivity() {
    val coinViewModel: CoinViewModel by viewModels()
    val coinDetailViewModel:CoinDetailViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        Log.e("TAG", " x");

        val adapter = CoinListAdapter { id: String ->
            val detailActivity = Intent(this, CoinDetailActivity::class.java)
            CoinDetailViewModel.coinsData.isLoading.observe(this, object : Observer<Boolean> {
                override fun onChanged(t: Boolean?) {
                    if (t == false) {
                        startActivity(detailActivity)
                        CoinDetailViewModel.coinsData.isLoading.removeObserver(this)
                    }
                }
            })
            val coinDetailUseCase =
                GetCoinDetailUseCase(AppMod.provideCoinRepository(AppMod.provideApi()))
            coinDetailViewModel.coinDetailUseCase = coinDetailUseCase
            coinDetailViewModel.getCoin(id)


        }
        adapter.submitList(CoinViewModel.coinsData.coinList)
        coinViewModel.coinListAdapter = adapter

        binding.coinVm = coinViewModel


    }
}