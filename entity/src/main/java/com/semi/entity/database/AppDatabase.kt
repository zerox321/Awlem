package com.semi.entity.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.semi.entity.database.categoryController.CategoryDao
import com.semi.entity.database.categoryController.CategoryEntity


@Database(
    entities = [CategoryEntity::class],
    version = 1, exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao

}
