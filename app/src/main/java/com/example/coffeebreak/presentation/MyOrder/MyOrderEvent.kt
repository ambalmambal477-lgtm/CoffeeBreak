package com.example.coffeebreak.presentation.MyOrder

sealed class MyOrderEvent {
    data object ShowPayPanel: MyOrderEvent()
}