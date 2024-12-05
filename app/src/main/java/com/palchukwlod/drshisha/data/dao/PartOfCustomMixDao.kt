package com.palchukwlod.drshisha.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.palchukwlod.drshisha.data.entity.customMix.CustomMix
import com.palchukwlod.drshisha.data.entity.customMix.PartOfCustomMix
import kotlinx.coroutines.flow.Flow

@Dao
interface PartOfCustomMixDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPartOfCustomMix(partOfCustomMix: PartOfCustomMix)

    @Delete
    suspend fun deletePartOfCustomMix(partOfCustomMix: PartOfCustomMix)

    @Query("SELECT * FROM part_of_shisha_mix_table WHERE customMixId=:customMixId")
    fun getAllPartOfCustomMixesById(customMixId: Int): Flow<List<PartOfCustomMix>>

    @Query("SELECT * FROM custom_mix_table WHERE customMixId=:customMixId")
    suspend fun getCustomMixById(customMixId: Int): CustomMix

    @Update
    suspend fun insertCustomMix(customMix: CustomMix)

    @Query("SELECT * FROM part_of_shisha_mix_table WHERE partOfMixId=:partOfMixId")
    suspend fun getPartOfCustomMixById(partOfMixId: Int): PartOfCustomMix


}