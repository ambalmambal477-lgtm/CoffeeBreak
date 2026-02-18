package com.example.coffeebreak.domain.repository

import com.example.coffeebreak.domain.model.Redeem

interface RedeemRepository {
    suspend fun getRedeemList(): List<Redeem>
}