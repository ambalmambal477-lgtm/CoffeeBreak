package com.example.coffeebreak.presentation.ResetPassword

data class ResetPasswordState (
    val password: String = "",
    val passwordValid: Boolean = false,
    val error: Boolean = false
)