package com.example.coffeebreak.data.repositoryImpl

import com.example.coffeebreak.data.Dto.CoffeeTypeDto
import com.example.coffeebreak.data.supabase.Connect.supabase
import com.example.coffeebreak.domain.model.CoffeeType
import com.example.coffeebreak.domain.repository.CoffeeTypeRepository
import io.github.jan.supabase.postgrest.postgrest

//реализация репозитория для сорта кофе
class CoffeeTypeRepositoryImpl: CoffeeTypeRepository{
    override suspend fun getCoffeeTypeList(): List<CoffeeType> {
        return supabase.postgrest["coffee_type"].select().decodeList<CoffeeTypeDto>()
    }
}