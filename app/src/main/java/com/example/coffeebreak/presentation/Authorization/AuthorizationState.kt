package com.example.coffeebreak.presentation.Authorization

import java.util.concurrent.CountedCompleter

data class AuthorizationState(
    val email: String = "",
    val password: String = "",
    val visual: Boolean = true,
    val isComplete: Boolean = false
)