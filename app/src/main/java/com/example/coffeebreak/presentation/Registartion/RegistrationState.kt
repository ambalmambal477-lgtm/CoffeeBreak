package com.example.coffeebreak.presentation.Registartion

data class RegistrationState(
    val name: String = "",
    val number: String = "",
    val email: String = "",
    val password: String = "",
    val visual: Boolean = true,
    val checked: Boolean = false,
    val isComplete: Boolean = false
)