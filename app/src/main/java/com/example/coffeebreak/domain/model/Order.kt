package com.example.coffeebreak.domain.model

interface Order {
    val id: Int
    val image: String
    val name: String
    val description: String
    val count: Int
    val price: Int
    val date: String
    val address: String
}