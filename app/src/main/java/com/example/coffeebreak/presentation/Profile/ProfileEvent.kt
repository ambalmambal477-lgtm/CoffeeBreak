package com.example.coffeebreak.presentation.Profile

sealed class ProfileEvent {
    data object ShowQR: ProfileEvent()
}