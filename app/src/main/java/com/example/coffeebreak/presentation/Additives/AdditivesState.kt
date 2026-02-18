package com.example.coffeebreak.presentation.Additives

import com.example.coffeebreak.domain.model.Additives

data class AdditivesState (
    val additivesList: List<Additives> = listOf(),
    val load: Boolean = true
)