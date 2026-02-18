package com.example.coffeebreak.data.repositoryImpl

import com.example.coffeebreak.data.Dto.CoffeeDto
import com.example.coffeebreak.data.supabase.Connect.supabase
import com.example.coffeebreak.domain.model.Coffee
import com.example.coffeebreak.domain.repository.CoffeeRepository
import io.github.jan.supabase.postgrest.postgrest

//реализация репозитория для кофе
class CoffeeRepositoryImpl: CoffeeRepository {
    override suspend fun getCoffeeList(): List<Coffee> {
        return supabase.postgrest["coffee"].select().decodeList<CoffeeDto>()
    }
}