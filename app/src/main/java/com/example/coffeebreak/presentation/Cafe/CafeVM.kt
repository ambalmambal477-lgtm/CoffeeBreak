package com.example.coffeebreak.presentation.Cafe

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeebreak.domain.repository.CoffeeShopRepository
import com.yandex.mapkit.geometry.Point
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CafeVM @Inject constructor(
    private val coffeeShopRepository: CoffeeShopRepository
): ViewModel() {
    private val _state = mutableStateOf(CafeState())
    val state: State<CafeState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val coffeeShopList = coffeeShopRepository.getCoffeeShopList()
                _state.value = state.value.copy(
                    coffeeShopList = coffeeShopList,
                    cafeLocations = coffeeShopList.map {
                        Point(it.latitude, it.longitude)
                    },
                    load = false
                )
            } catch (ex: Exception){
                Log.e("supa", ex.message.toString())
            }
        }
    }

    fun onEvent(event: CafeEvent) {
        when (event) {
            is CafeEvent.OnUserLocationReceived -> {
                _state.value = state.value.copy(
                    userLocation = event.value
                )
            }

            CafeEvent.Next -> {
                _state.value = state.value.copy(
                    isComplete = true
                )
            }
        }
    }
}