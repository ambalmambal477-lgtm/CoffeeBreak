package com.example.coffeebreak.data.Dto

import com.example.coffeebreak.domain.model.User

data class UserDto(override val email: String, override val password: String): User