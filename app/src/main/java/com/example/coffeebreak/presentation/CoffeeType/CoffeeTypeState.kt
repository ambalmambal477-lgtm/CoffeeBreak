package com.example.coffeebreak.presentation.CoffeeType

import com.example.coffeebreak.domain.model.CoffeeType

data class CoffeeTypeState (
    val coffeeTypeList: List<CoffeeType> = listOf(),
    val load: Boolean = true
)