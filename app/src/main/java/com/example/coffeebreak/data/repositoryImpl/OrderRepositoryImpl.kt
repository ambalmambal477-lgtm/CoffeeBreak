package com.example.coffeebreak.data.repositoryImpl

import com.example.coffeebreak.data.Dto.OrderDto
import com.example.coffeebreak.data.supabase.Connect.supabase
import com.example.coffeebreak.domain.model.Order
import com.example.coffeebreak.domain.repository.OrderRepository
import io.github.jan.supabase.postgrest.postgrest

// реализация репозитория заказов
class OrderRepositoryImpl: OrderRepository {
    override suspend fun getMyOrderList(): List<Order> {
        return supabase.postgrest["order"].select().decodeList<OrderDto>()
    }

    override suspend fun getMyOrderCurrent(): Order {
        return supabase.postgrest["order"].select().decodeSingle<OrderDto>()
    }
}