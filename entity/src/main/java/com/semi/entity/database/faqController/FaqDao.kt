package com.semi.entity.database.faqController

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/** A data access object about the [FaqEntity] entity. */
@Dao
interface FaqDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: List<FaqEntity>)

    @Query("SELECT * FROM FaqEntity ORDER BY id ASC")
    fun getList(): Flow<List<FaqEntity>>

    @Query("DELETE  FROM FaqEntity")
    fun deleteDb()
}
