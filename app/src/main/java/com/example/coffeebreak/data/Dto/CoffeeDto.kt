package com.example.coffeebreak.data.Dto

import com.example.coffeebreak.domain.model.Coffee
import kotlinx.serialization.Serializable

//dto для модели кофе
@Serializable
data class CoffeeDto(
    override val id: Int,
    override val name: String,
    override val image: String,
    override val price: Int,
): Coffee