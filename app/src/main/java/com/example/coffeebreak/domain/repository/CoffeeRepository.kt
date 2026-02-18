package com.example.coffeebreak.domain.repository

import com.example.coffeebreak.domain.model.Coffee

interface CoffeeRepository {
    suspend fun getCoffeeList(): List<Coffee>
}