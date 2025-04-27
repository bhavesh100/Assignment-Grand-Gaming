package com.bhavesh.grandgamingassignment.presentation.cats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhavesh.grandgamingassignment.domain.repository.CatRepository
import com.bhavesh.grandgamingassignment.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(
    private val repository: CatRepository
) : ViewModel() {

    private val _state = MutableStateFlow(CatListState())
    val state: StateFlow<CatListState> = _state.asStateFlow()

    init {
        getCats()
    }

    private fun getCats() {
        viewModelScope.launch {
            repository.getCats().collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _state.value = CatListState(isLoading = true)
                    }
                    is Resource.Success -> {
                        _state.value = CatListState(cats = result.data ?: emptyList())
                    }
                    is Resource.Error -> {
                        _state.value = CatListState(error = result.message ?: "Error")
                    }
                }
            }
        }
    }
}
