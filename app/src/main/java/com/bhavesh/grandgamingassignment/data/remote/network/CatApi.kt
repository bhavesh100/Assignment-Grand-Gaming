package com.bhavesh.grandgamingassignment.data.remote.network

import com.bhavesh.grandgamingassignment.data.remote.model.CatDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {
    @GET("v1/images/search")
    suspend fun getCats(
        @Query("limit")
        limit: Int = 10
    ): List<CatDto>
}