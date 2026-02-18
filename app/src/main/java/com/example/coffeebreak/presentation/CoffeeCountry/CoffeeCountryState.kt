package com.example.coffeebreak.presentation.CoffeeCountry

import com.example.coffeebreak.domain.model.Country

data class CoffeeCountryState(
    val coffeeCountryList: List<Country> = listOf(),
    val load: Boolean = true
)