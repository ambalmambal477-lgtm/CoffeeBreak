package com.example.coffeebreak.presentation.Menu

import com.example.coffeebreak.domain.model.Coffee

data class MenuState (
    val coffeeList: List<Coffee> = listOf(),
    val load: Boolean = true
)