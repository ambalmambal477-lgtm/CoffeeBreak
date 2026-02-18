package com.example.coffeebreak.presentation.Barista

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeebreak.domain.repository.BaristaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BaristaVM @Inject constructor(
    private val baristaRepository: BaristaRepository
): ViewModel() {
    private val _state = mutableStateOf(BaristaState())
    val state: State<BaristaState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val baristaList = baristaRepository.getBaristaList()
                _state.value = state.value.copy(
                    baristaList = baristaList,
                    load = false
                )
            } catch (ex: Exception){
                Log.e("supa", ex.message.toString())
            }
        }
    }
}