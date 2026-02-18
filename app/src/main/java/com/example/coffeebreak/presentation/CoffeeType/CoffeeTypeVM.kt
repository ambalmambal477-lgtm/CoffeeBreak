package com.example.coffeebreak.presentation.CoffeeType

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeebreak.domain.repository.CoffeeTypeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoffeeTypeVM @Inject constructor(
    private val coffeeTypeRepository: CoffeeTypeRepository
): ViewModel() {
    private val _state = mutableStateOf(CoffeeTypeState())
    val state: State<CoffeeTypeState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val coffeeTypeList = coffeeTypeRepository.getCoffeeTypeList()
                _state.value = state.value.copy(
                    coffeeTypeList = coffeeTypeList,
                    load = false
                )
            } catch (ex: Exception){
                Log.e("supa", ex.message.toString())
            }
        }
    }
}