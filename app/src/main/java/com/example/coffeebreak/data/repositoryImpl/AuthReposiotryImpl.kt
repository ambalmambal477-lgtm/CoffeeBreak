package com.example.coffeebreak.data.repositoryImpl

import com.example.coffeebreak.data.supabase.Connect.supabase
import com.example.coffeebreak.domain.model.User
import com.example.coffeebreak.domain.repository.AuthRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email

// реализация репозитория авторизации
class AuthRepositoryImpl: AuthRepository {
    override suspend fun auth(inputEmail: String, inputPassword: String) {
        supabase.auth.signInWith(Email){
            email = inputEmail
            password = inputPassword
        }
    }

    override suspend fun registration(inputEmail: String, inputPassword: String) {
        supabase.auth.signUpWith(Email){
            email = inputEmail
            password = inputPassword
        }
    }

}