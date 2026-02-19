package com.example.coffeebreak.domain.repository

import com.example.coffeebreak.domain.model.Order

interface OrderRepository {
    suspend fun getMyOrderList(): List<Order>
    suspend fun getMyOrderCurrent(): Order
}