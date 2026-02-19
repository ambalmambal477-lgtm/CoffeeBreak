package com.example.coffeebreak.presentation.MyOrderHistory

import com.example.coffeebreak.domain.model.Order

data class MyOrderHistoryState(
    val orderList: List<Order> = listOf(),
    val load: Boolean = true
)