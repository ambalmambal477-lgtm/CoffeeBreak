package com.example.coffeebreak

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

sealed class Navigation {
    @Serializable
    data object Welcome: Navigation()

    @Serializable
    data object Auth: Navigation()

    @Serializable
    data object Startup: Navigation()

    @Serializable
    data object Registration: Navigation()

    @Serializable
    data object Cafe: Navigation()

    @Serializable
    data object Menu: Navigation()

    @Serializable
    data object ForgotPassword: Navigation()

    @Serializable
    data object TwoFactor: Navigation()

    @Serializable
    data object ResetPassword: Navigation()

    @Serializable
    data object RewardScreen: Navigation()

    @Serializable
    data object MyOrderHistory: Navigation()

    @Serializable
    data object Profile: Navigation()

    @Serializable
    data object OrderOptions: Navigation()

    @Serializable
    data object Redeem: Navigation()
}