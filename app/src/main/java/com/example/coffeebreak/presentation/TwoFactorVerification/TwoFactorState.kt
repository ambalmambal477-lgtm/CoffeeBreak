package com.example.coffeebreak.presentation.TwoFactorVerification

data class TwoFactorState (
    val firstNumber: String = "",
    val secondNumber: String = "",
    val thirdNumber: String = "",
    val fourthNumber: String = "",
    val time: Int = 30
)