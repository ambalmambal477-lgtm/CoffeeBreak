package com.example.coffeebreak.domain.repository

import com.example.coffeebreak.domain.model.Profile

interface ProfileRepository {
    suspend fun getProfileFOrMyOrder(): Profile
}