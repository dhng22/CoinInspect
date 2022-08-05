package com.example.coininspect.presentation.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.coininspect.R
import com.example.coininspect.data.di.AppMod
import com.example.coininspect.domain.use_cases.GetCoinUseCase
import com.example.coininspect.presentation.view_model.CoinViewModel

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        retrieveCoinData()
    }

    private fun retrieveCoinData() {
        val coinViewModel:CoinViewModel by viewModels()
        coinViewModel.coinUseCase=GetCoinUseCase(AppMod.provideCoinRepository(AppMod.provideApi()))

        coinViewModel.getCoin()
        CoinViewModel.coinsData.isLoading.observe(this){
            if (it == false) {
                Log.e("TAG", "${CoinViewModel.coinsData.coinList} ");
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
}