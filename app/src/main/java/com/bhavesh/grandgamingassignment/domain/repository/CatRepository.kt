package com.bhavesh.grandgamingassignment.domain.repository

import com.bhavesh.grandgamingassignment.domain.model.Cat
import com.bhavesh.grandgamingassignment.util.Resource
import kotlinx.coroutines.flow.Flow

interface CatRepository {
    fun getCats(): Flow<Resource<List<Cat>>>
}