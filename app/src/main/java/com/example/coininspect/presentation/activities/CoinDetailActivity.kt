package com.example.coininspect.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coininspect.R
import com.example.coininspect.data.remote.dto.Tag
import com.example.coininspect.data.remote.dto.Team
import com.example.coininspect.databinding.ActivityCoinDetailBinding
import com.example.coininspect.presentation.adapter.TagListAdapter
import com.example.coininspect.presentation.adapter.TeamListAdapter
import com.example.coininspect.presentation.view_model.CoinDetailViewModel

class CoinDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityCoinDetailBinding
    val coinDetailViewModel: CoinDetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_coin_detail)
        binding.lifecycleOwner = this
        coinDetailViewModel.browseOnClick = { intent -> startActivity(intent) }


        binding.tagSize = CoinDetailViewModel.coinsData.coinDetail?.tags?.size

        val tagListAdapter: ListAdapter<Tag, RecyclerView.ViewHolder> = TagListAdapter()
        val teamListAdapter:ListAdapter<Team,RecyclerView.ViewHolder> = TeamListAdapter()


        binding.coinDetail = CoinDetailViewModel.coinsData.coinDetail
        tagListAdapter.submitList(CoinDetailViewModel.coinsData.coinDetail?.tags)
        teamListAdapter.submitList(CoinDetailViewModel.coinsData.coinDetail?.team)
        coinDetailViewModel.teamAdapter = teamListAdapter
        coinDetailViewModel.tagAdapter = tagListAdapter
        binding.coinDetailVm = coinDetailViewModel


    }

}