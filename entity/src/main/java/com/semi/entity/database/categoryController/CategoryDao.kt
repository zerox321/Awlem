package com.semi.entity.database.categoryController

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/** A data access object about the [CategoryEntity] entity. */
@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: List<CategoryEntity>)

    @Query("SELECT * FROM CategoryEntity ORDER BY id ASC")
    fun getList(): Flow<List<CategoryEntity>>

    @Query("DELETE  FROM CategoryEntity")
    fun deleteDb()
}
