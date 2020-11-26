package com.semi.entity.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.semi.entity.database.categoryController.CategoryDao
import com.semi.entity.database.categoryController.CategoryEntity
import com.semi.entity.database.faqController.FaqDao
import com.semi.entity.database.faqController.FaqEntity


@Database(
    entities = [FaqEntity::class, CategoryEntity::class],
    version = 2, exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun faqDao(): FaqDao

}
