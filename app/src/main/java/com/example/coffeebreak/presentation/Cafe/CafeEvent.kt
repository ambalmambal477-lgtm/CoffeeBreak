package com.example.coffeebreak.presentation.Cafe

import com.yandex.mapkit.geometry.Point

sealed class CafeEvent {
    data class OnUserLocationReceived(val value: Point): CafeEvent()
    data object Next: CafeEvent()
}