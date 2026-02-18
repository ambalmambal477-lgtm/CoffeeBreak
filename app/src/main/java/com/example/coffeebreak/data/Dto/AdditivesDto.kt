package com.example.coffeebreak.data.Dto

import com.example.coffeebreak.domain.model.Additives
import kotlinx.serialization.Serializable

//dto для модели добавок
@Serializable
data class AdditivesDto(
    override val id: Int,
    override val image: String,
    override val name: String,
    override val description: String
): Additives