package com.example.coffeebreak.data.repositoryImpl

import com.example.coffeebreak.data.Dto.BaristaDto
import com.example.coffeebreak.data.supabase.Connect.supabase
import com.example.coffeebreak.domain.model.Barista
import com.example.coffeebreak.domain.repository.BaristaRepository
import io.github.jan.supabase.postgrest.postgrest

//реализация репозитория для бариста
class BaristaRepositoryImpl: BaristaRepository {
    override suspend fun getBaristaList(): List<Barista> {
        return supabase.postgrest["barista"].select().decodeList<BaristaDto>()
    }
}