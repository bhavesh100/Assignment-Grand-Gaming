package com.bhavesh.grandgamingassignment.presentation.cats

import com.bhavesh.grandgamingassignment.domain.model.Cat

data class CatListState(
    val isLoading: Boolean = false,
    val cats: List<Cat> = emptyList(),
    val error: String = ""
)
