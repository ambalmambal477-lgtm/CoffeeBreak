package com.example.coffeebreak.presentation.ForgotPassword

data class ForgotPasswordState(
    val email: String = "",
    val emailValid: Boolean = false,
    val error: Boolean = false
)
