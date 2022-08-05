package com.example.coininspect.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coininspect.databinding.RowCoinBinding
import com.example.coininspect.domain.model.Coin
import com.example.coininspect.presentation.DiffCoinCallBack

class CoinListAdapter(val onClickNavigate: (String) -> Unit) : ListAdapter<Coin, RecyclerView.ViewHolder>(
    DiffCoinCallBack()
) {
    class CoinHolder(val binding: RowCoinBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(coin: Coin,position: Int): Unit {
            binding.coin = coin
            binding.order = position+1
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = RowCoinBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.context = parent.context
        binding.adapter = this
        return CoinHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CoinHolder).onBind(getItem(position),position)
    }
    fun toDetailActivity(id:String) {
        onClickNavigate.invoke(id)
    }
}