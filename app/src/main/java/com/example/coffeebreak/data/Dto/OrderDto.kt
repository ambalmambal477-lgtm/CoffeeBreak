package com.example.coffeebreak.data.Dto

import com.example.coffeebreak.domain.model.Order
import kotlinx.serialization.Serializable

//dto для модели заказов
@Serializable
data class OrderDto(
    override val id: Int,
    override val image: String,
    override val name: String,
    override val description: String,
    override val count: Int,
    override val price: Int,
    override val date: String,
    override val address: String
): Order