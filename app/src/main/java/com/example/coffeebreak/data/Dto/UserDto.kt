package com.example.coffeebreak.data.Dto

import com.example.coffeebreak.domain.model.User
import kotlinx.serialization.Serializable

// dto для модели пользователя
@Serializable
data class UserDto(override val email: String, override val password: String): User