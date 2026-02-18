package com.example.coffeebreak.data.Dto

import com.example.coffeebreak.domain.model.Barista
import kotlinx.serialization.Serializable

//dto для модели бариста
@Serializable
class BaristaDto(
    override val id: Int,
    override val image: String,
    override val name: String,
    override val status: String
): Barista