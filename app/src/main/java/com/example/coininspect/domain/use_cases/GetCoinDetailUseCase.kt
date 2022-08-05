package com.example.coininspect.domain.use_cases

import com.example.coininspect.common.Resource
import com.example.coininspect.data.remote.dto.toCoin
import com.example.coininspect.data.remote.dto.toCoinDetail
import com.example.coininspect.domain.model.Coin
import com.example.coininspect.domain.model.CoinDetail
import com.example.coininspect.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCoinDetailUseCase (val coinRepository: CoinRepository) {
    operator fun invoke(id:String): Flow<Resource<CoinDetail>> = flow{
        try {
            emit(Resource.Loading<CoinDetail>())
            val coinData= coinRepository.getCoinById(id).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coinData))
            emit(Resource.Loading<CoinDetail>())
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Could not connect to the server, please try later"))
        }
    }
}