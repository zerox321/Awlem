package com.semi.entity.database.cartController

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/** A data access object about the [CartEntity] entity. */
@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: List<CartEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(list: CartEntity)

    @Query("SELECT * FROM CartEntity ORDER BY id ASC")
    fun getList(): Flow<List<CartEntity>>

    @Query("DELETE  FROM CategoryEntity")
    fun deleteDb()
}
