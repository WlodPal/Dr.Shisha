package com.palchukwlod.drshisha.data.repositories

import com.palchukwlod.drshisha.data.entity.customMix.CustomMix
import com.palchukwlod.drshisha.data.entity.customMix.PartOfCustomMix
import kotlinx.coroutines.flow.Flow

interface PartOfCustomMixRepository {

    suspend fun insertPartOfCustomMix(partOfCustomMix: PartOfCustomMix)

    suspend fun deletePartOfCustomMix(partOfCustomMix: PartOfCustomMix)

    fun getAllPartOfCustomMixesById(customMixId: Int): Flow<List<PartOfCustomMix>>

    suspend fun getCustomMixById(customMixId: Int): CustomMix

    suspend fun insertCustomMix(customMix: CustomMix)

    suspend fun getPartOfCustomMixById(partOfMixId: Int): PartOfCustomMix

}