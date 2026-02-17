package com.example.coffeebreak.domain.repository

import com.example.coffeebreak.domain.model.User
import com.example.coffeebreak.presentation.Registartion.RegistrationEvent

// репозиторий для регистрации и авторизации
interface AuthRepository {
    suspend fun auth(inputEmail: String, inputPassword: String)
    suspend fun registration(inputEmail: String, inputPassword: String)
}