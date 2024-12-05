package com.palchukwlod.drshisha.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.palchukwlod.drshisha.data.entity.customMix.CustomMix
import kotlinx.coroutines.flow.Flow


@Dao
interface CustomMixDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomMix(customMix: CustomMix)

    @Delete
    suspend fun deleteCustomMix(customMix: CustomMix)

    @Query("SELECT * FROM custom_mix_table")
    fun getAllCustomMixes(): Flow<List<CustomMix>>

    @Query("SELECT * FROM custom_mix_table WHERE mixName " +
            "LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchMix(searchQuery: String): Flow<List<CustomMix>>

    @Query("SELECT * FROM custom_mix_table ORDER BY CASE " +
            "WHEN levelOfStrong LIKE 'L%' " +
            "THEN 1 WHEN levelOfStrong LIKE 'M%' " +
            "THEN 2 WHEN levelOfStrong LIKE 'S%' THEN 3 END")
    fun sortByLightLevel(): Flow<List<CustomMix>>


    @Query("SELECT * FROM custom_mix_table ORDER BY CASE " +
            "WHEN levelOfStrong LIKE 'S%' " +
            "THEN 1 WHEN levelOfStrong LIKE 'M%' " +
            "THEN 2 WHEN levelOfStrong LIKE 'L%' THEN 3 END")
    fun sortByStrongLevel(): Flow<List<CustomMix>>


    @Query("SELECT * FROM custom_mix_table ORDER BY CASE " +
            "WHEN levelOfStrong LIKE 'M%' " +
            "THEN 1 WHEN levelOfStrong LIKE 'S%' " +
            "THEN 2 WHEN levelOfStrong LIKE 'L%' THEN 3 END")
    fun sortByMediumLevel(): Flow<List<CustomMix>>




}