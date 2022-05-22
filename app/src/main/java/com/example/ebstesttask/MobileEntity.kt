package com.example.ebstesttask

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "models-mobile")
data class MobileEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val image: Int = 0,
    val name: String = "",
    val characteristic: String = "",
    val price: String = "",
    val information: String = "",
    val isChecked: Int = 0,
    val isSelected: Boolean = false
)