package com.example.coffeebreak.presentation.Authorization

sealed class AuthorizationEvent {
    data class EnteredEmail(val value: String): AuthorizationEvent()
    data class EnteredPassword(val value: String): AuthorizationEvent()
    data object VisualTranform: AuthorizationEvent()
    data object Auth: AuthorizationEvent()
}