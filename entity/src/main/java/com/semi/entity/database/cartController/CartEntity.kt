package com.semi.entity.database.cartController

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CartEntity(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val name: String? = "",
    val photo: String? = "",
    val price: Double? = 0.0,
    val quantity: Int? = 0
)
