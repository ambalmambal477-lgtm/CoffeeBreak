package com.example.coffeebreak.presentation.Redeem

import com.example.coffeebreak.domain.model.Redeem

data class RedeemState(
    val redeemList: List<Redeem> = listOf(),
    val load: Boolean = true
)
