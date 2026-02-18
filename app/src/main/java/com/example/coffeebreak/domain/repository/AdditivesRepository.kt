package com.example.coffeebreak.domain.repository

import com.example.coffeebreak.domain.model.Additives

interface AdditivesRepository {
    suspend fun getAdditivesList(): List<Additives>
}