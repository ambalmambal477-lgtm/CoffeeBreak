package com.example.coffeebreak.data.Dto

import com.example.coffeebreak.domain.model.Country
import kotlinx.serialization.Serializable

//dto для модели страны
@Serializable
data class CountryDto(
    override val id: Int,
    override val image: String,
    override val name: String,
    override val description: String
): Country
