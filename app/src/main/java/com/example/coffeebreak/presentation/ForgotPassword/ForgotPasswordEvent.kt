package com.example.coffeebreak.presentation.ForgotPassword

sealed class ForgotPasswordEvent {
    data class EnteredEmail(val value: String): ForgotPasswordEvent()
    data object IsEmailValid: ForgotPasswordEvent()
    data object ShowError: ForgotPasswordEvent()
}