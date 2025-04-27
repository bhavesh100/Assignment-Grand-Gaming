package com.bhavesh.grandgamingassignment.data.repository

import com.bhavesh.grandgamingassignment.data.remote.mapper.toDomain
import com.bhavesh.grandgamingassignment.data.remote.network.CatApi
import com.bhavesh.grandgamingassignment.domain.model.Cat
import com.bhavesh.grandgamingassignment.domain.repository.CatRepository
import com.bhavesh.grandgamingassignment.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(
    private val api: CatApi
) : CatRepository {
    override fun getCats(): Flow<Resource<List<Cat>>> = flow {
        emit(Resource.Loading())
        try {
            val cats = api.getCats().map { it.toDomain() }
            emit(Resource.Success(cats))
        } catch (e: HttpException){
            emit(Resource.Error(e.message()))
        } catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check Your Internet Connection."))
        }
    }
}
