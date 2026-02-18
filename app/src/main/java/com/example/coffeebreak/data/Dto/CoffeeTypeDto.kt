package com.example.coffeebreak.data.Dto

import com.example.coffeebreak.domain.model.CoffeeType
import kotlinx.serialization.Serializable

//dto для модели сорта кофе
@Serializable
data class CoffeeTypeDto(
    override val id: Int,
    override val image: String,
    override val name: String,
    override val description: String
): CoffeeType
