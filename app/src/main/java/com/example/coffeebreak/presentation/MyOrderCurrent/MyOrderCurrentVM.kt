package com.example.coffeebreak.presentation.MyOrderCurrent

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeebreak.domain.repository.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyOrderCurrentVM @Inject constructor(
    private val orderRepository: OrderRepository
): ViewModel() {
    private val _state = mutableStateOf(MyOrderCurrentState())
    val state: State<MyOrderCurrentState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val order = orderRepository.getMyOrderCurrent()
                _state.value = state.value.copy(
                    id = order.id,
                    image = order.image,
                    name = order.name,
                    count = order.count,
                    date = order.date,
                    price = order.price,
                    load = false
                )
            } catch (ex: Exception){
                Log.e("supa", ex.message.toString())
            }
        }
    }
}