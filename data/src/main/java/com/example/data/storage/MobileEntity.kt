package com.example.data.storage

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "models-mobile")
data class MobileEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var image: Int,
    var name: String,
    var details: String,
    var price: String,
    var size: String,
    var colour: String,
    var isChecked: Int,
    var isSelected: Boolean = false
)