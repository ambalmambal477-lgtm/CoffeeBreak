package com.example.coffeebreak.domain.repository

import com.example.coffeebreak.domain.model.Barista

interface BaristaRepository {
    suspend fun getBaristaList(): List<Barista>
}