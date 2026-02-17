package com.example.coffeebreak.domain.usecase

class IsPasswordValidUseCase {
    operator fun invoke(password: String): Boolean{
        return password.length >= 8 &&
                password.any{it.isLowerCase()} &&
                password.any{it.isUpperCase()} &&
                password.any{it.isDigit()} &&
                password.any{it.isWhitespace()} &&
                password.any{!it.isDigit() && !it.isWhitespace()}

    }
}