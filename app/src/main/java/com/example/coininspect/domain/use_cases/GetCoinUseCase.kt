package com.example.coininspect.domain.use_cases

import com.example.coininspect.common.Resource
import com.example.coininspect.data.remote.dto.toCoin
import com.example.coininspect.domain.model.Coin
import com.example.coininspect.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCoinUseCase(private val coinRepository: CoinRepository) {
    operator fun invoke():Flow<Resource<List<Coin>>> = flow{
        try {
            emit(Resource.Loading<List<Coin>>())
            val coinData= coinRepository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coinData))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Could not connect to the server, please try later"))
        }
    }
}