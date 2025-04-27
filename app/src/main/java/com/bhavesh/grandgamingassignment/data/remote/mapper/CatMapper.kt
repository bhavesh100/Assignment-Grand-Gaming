package com.bhavesh.grandgamingassignment.data.remote.mapper

import com.bhavesh.grandgamingassignment.data.remote.model.CatDto
import com.bhavesh.grandgamingassignment.domain.model.Cat

fun CatDto.toDomain(): Cat {
    return Cat(
        id = id,
        imageUrl = url
    )
}