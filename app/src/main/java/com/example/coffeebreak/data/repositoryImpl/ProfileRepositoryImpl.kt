package com.example.coffeebreak.data.repositoryImpl

import com.example.coffeebreak.data.Dto.ProfileDto
import com.example.coffeebreak.data.supabase.Connect.supabase
import com.example.coffeebreak.domain.model.Profile
import com.example.coffeebreak.domain.repository.ProfileRepository
import io.github.jan.supabase.postgrest.postgrest

//реализация репозитория профиля
class ProfileRepositoryImpl: ProfileRepository {
    override suspend fun getProfileFOrMyOrder(): Profile {
        return supabase.postgrest["profile"].select().decodeSingle<ProfileDto>()
    }

}