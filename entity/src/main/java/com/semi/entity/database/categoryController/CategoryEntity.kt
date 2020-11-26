package com.semi.entity.database.categoryController

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CategoryEntity(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val name: String?,
    val photo: String?
)
