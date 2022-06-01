package com.example.domain.models

data class Phone(
    var id: Int,
    var image: String,
    var name: String,
    var details: String,
    var price: String,
    var size: String,
    var colour: String,
    var isChecked: Int = 0,
    var isSelected: Boolean = false
)
