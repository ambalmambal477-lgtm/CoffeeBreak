package com.example.coffeebreak.presentation.MyOrder

import com.example.coffeebreak.domain.model.Order
import com.example.coffeebreak.domain.model.Profile

data class MyOrderState(
    val orderList: List<Order> = listOf(),
    val load: Boolean = true,
    val payPanel: Boolean = false,
    val totalSum: Int = 0,
    val name: String = "",
    val address: String = ""
)
