package com.example.coffeebreak.data.repositoryImpl

import com.example.coffeebreak.data.Dto.CoffeeShopDto
import com.example.coffeebreak.data.supabase.Connect.supabase
import com.example.coffeebreak.domain.model.CoffeeShop
import com.example.coffeebreak.domain.repository.CoffeeShopRepository
import io.github.jan.supabase.postgrest.postgrest

//реализация репозитория кофейнь
class CoffeeRepositoryImpl: CoffeeShopRepository {
    override suspend fun getCoffeeShopList(): List<CoffeeShop> {
        return supabase.postgrest["coffee_shop"].select().decodeList<CoffeeShopDto>()
    }
}