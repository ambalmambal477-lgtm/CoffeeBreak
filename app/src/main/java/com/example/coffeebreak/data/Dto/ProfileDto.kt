package com.example.coffeebreak.data.Dto

import com.example.coffeebreak.domain.model.Profile
import kotlinx.serialization.Serializable

//dto для модели профиля
@Serializable
data class ProfileDto(
    override val id: Int,
    override val name: String,
    override val address: String
): Profile