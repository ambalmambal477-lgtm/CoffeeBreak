package com.example.coffeebreak.domain.repository

import com.example.coffeebreak.domain.model.CoffeeShop

interface CoffeeShopRepository {
    suspend fun getCoffeeShopList(): List<CoffeeShop>
}