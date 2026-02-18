package com.example.coffeebreak.presentation.Menu

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeebreak.domain.repository.CoffeeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuVM @Inject constructor(
    private val cofeeRepository: CoffeeRepository
): ViewModel() {
    private val _state = mutableStateOf(MenuState())
    val state: State<MenuState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val coffeeList = cofeeRepository.getCoffeeList()
                _state.value = state.value.copy(
                    coffeeList = coffeeList,
                    load = false
                )
            } catch (ex: Exception){
                Log.e("supa", ex.message.toString())
            }
        }
    }
}