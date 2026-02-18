package com.example.coffeebreak.domain.repository

import com.example.coffeebreak.domain.model.Country

interface CountryRepository {
    suspend fun getCountryList(): List<Country>
}