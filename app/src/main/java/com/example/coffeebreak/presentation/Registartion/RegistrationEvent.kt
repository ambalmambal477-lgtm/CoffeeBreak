package com.example.coffeebreak.presentation.Registartion

sealed class RegistrationEvent {
    data class EnteredName(val value: String): RegistrationEvent()
    data class EnteredNumber(val value: String): RegistrationEvent()
    data class EnteredEmail(val value: String): RegistrationEvent()
    data class EnteredPassword(val value: String): RegistrationEvent()
    data object ChangeVisual: RegistrationEvent()
    data object Checked: RegistrationEvent()
    data object Registration: RegistrationEvent()
}