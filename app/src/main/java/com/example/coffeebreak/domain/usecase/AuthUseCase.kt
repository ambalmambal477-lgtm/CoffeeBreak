package com.example.coffeebreak.domain.usecase

import com.example.coffeebreak.domain.model.User
import com.example.coffeebreak.domain.repository.AuthRepository

class AuthUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(inputEmail: String, inputPassword: String){
        authRepository.auth(inputEmail, inputPassword)
    }
}