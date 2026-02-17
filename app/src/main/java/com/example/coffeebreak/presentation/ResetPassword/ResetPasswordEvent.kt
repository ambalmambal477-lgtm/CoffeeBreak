package com.example.coffeebreak.presentation.ResetPassword

sealed class ResetPasswordEvent {
    data class EnteredPassword(val value: String): ResetPasswordEvent()
    data object PasswordValid: ResetPasswordEvent()
    data object ShowError: ResetPasswordEvent()
}