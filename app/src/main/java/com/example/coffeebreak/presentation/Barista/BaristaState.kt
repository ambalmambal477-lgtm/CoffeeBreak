package com.example.coffeebreak.presentation.Barista

import com.example.coffeebreak.domain.model.Barista

data class BaristaState(
    val baristaList: List<Barista> = listOf(),
    val load: Boolean = true
)
