package com.example.coffeebreak.data.repositoryImpl

import com.example.coffeebreak.data.Dto.CountryDto
import com.example.coffeebreak.data.supabase.Connect.supabase
import com.example.coffeebreak.domain.model.Country
import com.example.coffeebreak.domain.repository.CountryRepository
import io.github.jan.supabase.postgrest.postgrest

//реализация репозитория для страны
class CountryRepositoryImpl: CountryRepository {
    override suspend fun getCountryList(): List<Country> {
        return supabase.postgrest["country"].select().decodeList<CountryDto>()
    }
}