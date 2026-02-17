package com.example.coffeebreak.presentation.Cafe

import com.example.coffeebreak.domain.model.CoffeeShop
import com.yandex.mapkit.geometry.Point

data class CafeState(
    val userLocation: Point? = null,
    val cafeLocations: List<Point> = listOf(),
    val load: Boolean = true,
    val coffeeShopList: List<CoffeeShop> = listOf(),
    val isComplete: Boolean = false
)
