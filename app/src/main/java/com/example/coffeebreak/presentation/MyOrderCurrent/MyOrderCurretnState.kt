package com.example.coffeebreak.presentation.MyOrderCurrent

import com.example.coffeebreak.domain.model.Order

data class MyOrderCurrentState(
    val id: Int = 0,
    val image: String = "",
    val name: String = "",
    val count: Int = 0,
    val date: String = "",
    val price: Int = 0,
    val load: Boolean = true
)