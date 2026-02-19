package com.example.coffeebreak.presentation.MyOrderHistory

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
class MyOrderHistoryVM @Inject constructor(
    private val orderRepository: OrderRepository
): ViewModel() {
    private val _state = mutableStateOf(MyOrderHistoryState())
    val state: State<MyOrderHistoryState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val orderList = orderRepository.getMyOrderList()
                _state.value = state.value.copy(
                    orderList = orderList,
                    load = false
                )
            } catch (ex: Exception){
                Log.e("supa", ex.message.toString())
            }
        }
    }
}