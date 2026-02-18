package com.example.coffeebreak.data.Dto

import com.example.coffeebreak.domain.model.Redeem
import kotlinx.serialization.Serializable

//dto для модели оплаты баллами
@Serializable
data class RedeemDto(
    override val id: Int,
    override val image: String,
    override val name: String,
    override val date: String,
    override val points: Int
): Redeem
