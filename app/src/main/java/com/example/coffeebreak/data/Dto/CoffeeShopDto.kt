package com.example.coffeebreak.data.Dto

import com.example.coffeebreak.domain.model.CoffeeShop
import kotlinx.serialization.Serializable

// dto для модели кофейнь
@Serializable
data class CoffeeShopDto(
    override val address: String,
    override val latitude: Double,
    override val longitude: Double
): CoffeeShop