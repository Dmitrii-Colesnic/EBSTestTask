package com.example.data.internet

data class Product(
    var count: Int,
    var total_pages: Int,
    var per_page: Int,
    var current_page: Int,
    var results: List<Results>
)

data class Results(
    var category: Category,
    var name: String,
    var details: String,
    var size: String,
    var colour: String,
    var price: Float,
    var main_image: String,
    var id: Int
)

data class Category(
    var name: String,
    var icon: String,
    var id: Int
)