package com.example.coffeebreak.data.repositoryImpl

import com.example.coffeebreak.data.Dto.AdditivesDto
import com.example.coffeebreak.data.supabase.Connect.supabase
import com.example.coffeebreak.domain.model.Additives
import com.example.coffeebreak.domain.repository.AdditivesRepository
import io.github.jan.supabase.postgrest.postgrest

class AdditivesRepositoryImpl: AdditivesRepository {
    override suspend fun getAdditivesList(): List<Additives> {
        return supabase.postgrest["additives"].select().decodeList<AdditivesDto>()
    }
}