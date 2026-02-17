package com.example.coffeebreak.presentation.TwoFactorVerification

sealed class TwoFactorEvent {
    data class EnteredFirstNumber(val value: String): TwoFactorEvent()
    data class EnteredSecondNumber(val value: String): TwoFactorEvent()
    data class EnteredThirdNumber(val value: String): TwoFactorEvent()
    data class EnteredFourthNumber(val value: String): TwoFactorEvent()
}