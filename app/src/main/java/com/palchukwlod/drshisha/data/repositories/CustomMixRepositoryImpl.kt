package com.palchukwlod.drshisha.data.repositories

import com.palchukwlod.drshisha.data.dao.CustomMixDao
import com.palchukwlod.drshisha.data.entity.customMix.CustomMix
import kotlinx.coroutines.flow.Flow

class CustomMixRepositoryImpl(
    private val customMixDao: CustomMixDao
) : CustomMixRepository {

    override suspend fun insertCustomMix(customMix: CustomMix) {
        customMixDao.insertCustomMix(customMix = customMix)
    }

    override suspend fun deleteCustomMix(customMix: CustomMix) {
        customMixDao.deleteCustomMix(customMix = customMix)
    }

    override fun getAllCustomMixes(): Flow<List<CustomMix>> {
        return customMixDao.getAllCustomMixes()
    }

    override fun searchMix(searchQuery: String): Flow<List<CustomMix>> {
        return customMixDao.searchMix(searchQuery = searchQuery)
    }

    override fun sortByLightLevel(): Flow<List<CustomMix>> {
        return customMixDao.sortByLightLevel()
    }

    override fun sortByStrongLevel(): Flow<List<CustomMix>> {
        return customMixDao.sortByStrongLevel()
    }

    override fun sortByMediumLevel(): Flow<List<CustomMix>> {
        return customMixDao.sortByMediumLevel()
    }

}