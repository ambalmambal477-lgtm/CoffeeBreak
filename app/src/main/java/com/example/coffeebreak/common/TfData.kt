package com.example.coffeebreak.common

data class TfData(
    val leadingIcon: Int,
    val placeholder: String,
    val value: String,
    val onValueChange: (String) -> Unit,
    val trailingIcon: Boolean,
    val visual: Boolean,
    val visualChange: () -> Unit,
    val padding: Int
)
