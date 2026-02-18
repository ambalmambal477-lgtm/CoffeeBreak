package com.example.coffeebreak.domain.repository

import com.example.coffeebreak.domain.model.CoffeeType

interface CoffeeTypeRepository {
    suspend fun getCoffeeTypeList(): List<CoffeeType>
}