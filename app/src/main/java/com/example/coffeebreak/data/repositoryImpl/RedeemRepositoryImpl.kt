package com.example.coffeebreak.data.repositoryImpl

import com.example.coffeebreak.data.Dto.RedeemDto
import com.example.coffeebreak.data.supabase.Connect.supabase
import com.example.coffeebreak.domain.model.Redeem
import com.example.coffeebreak.domain.repository.RedeemRepository
import io.github.jan.supabase.postgrest.postgrest

class RedeemRepositoryImpl: RedeemRepository {
    override suspend fun getRedeemList(): List<Redeem> {
        return supabase.postgrest["redeem"].select().decodeList<RedeemDto>()
    }
}