package com.example.coffeebreak.presentation.MyOrder

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeebreak.domain.repository.OrderRepository
import com.example.coffeebreak.domain.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyOrderVM @Inject constructor(
    private val orderRepository: OrderRepository,
    private val profileRepository: ProfileRepository
): ViewModel() {
    private val _state = mutableStateOf(MyOrderState())
    val state: State<MyOrderState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val orderList = orderRepository.getMyOrderList()
                var totalSum: Int = 0
                orderList.map { order ->
                    totalSum = totalSum + order.price
                }
                val profile = profileRepository.getProfileFOrMyOrder()
                _state.value = state.value.copy(
                    orderList = orderList,
                    totalSum = totalSum,
                    name = profile.name,
                    address = profile.address,
                    load = false
                )
            } catch (ex: Exception){
                Log.e("supa", ex.message.toString())
            }
        }
    }

    fun onEvent(event: MyOrderEvent){
        when(event){
            MyOrderEvent.ShowPayPanel -> {
                _state.value = state.value.copy(
                    payPanel = !state.value.payPanel
                )
            }
        }
    }
}