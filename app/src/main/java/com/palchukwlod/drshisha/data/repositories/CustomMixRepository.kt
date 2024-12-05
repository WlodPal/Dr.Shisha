package com.palchukwlod.drshisha.data.repositories

import com.palchukwlod.drshisha.data.entity.customMix.CustomMix
import kotlinx.coroutines.flow.Flow

interface CustomMixRepository {

    suspend fun insertCustomMix(customMix: CustomMix)

    suspend fun deleteCustomMix(customMix: CustomMix)

    fun getAllCustomMixes(): Flow<List<CustomMix>>

    fun searchMix(searchQuery: String): Flow<List<CustomMix>>

    fun sortByLightLevel(): Flow<List<CustomMix>>

    fun sortByStrongLevel(): Flow<List<CustomMix>>

    fun sortByMediumLevel(): Flow<List<CustomMix>>

}