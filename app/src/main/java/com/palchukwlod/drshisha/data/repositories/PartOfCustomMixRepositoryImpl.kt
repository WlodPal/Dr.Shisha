package com.palchukwlod.drshisha.data.repositories

import com.palchukwlod.drshisha.data.dao.PartOfCustomMixDao
import com.palchukwlod.drshisha.data.entity.customMix.CustomMix
import com.palchukwlod.drshisha.data.entity.customMix.PartOfCustomMix
import kotlinx.coroutines.flow.Flow

class PartOfCustomMixRepositoryImpl(
    private val partOfCustomMixDao: PartOfCustomMixDao
) : PartOfCustomMixRepository {

    override suspend fun insertPartOfCustomMix(partOfCustomMix: PartOfCustomMix) {
        partOfCustomMixDao.insertPartOfCustomMix(partOfCustomMix = partOfCustomMix)
    }

    override suspend fun insertCustomMix(customMix: CustomMix) {
        partOfCustomMixDao.insertCustomMix(customMix = customMix)
    }

    override suspend fun deletePartOfCustomMix(partOfCustomMix: PartOfCustomMix) {
        partOfCustomMixDao.deletePartOfCustomMix(partOfCustomMix = partOfCustomMix)
    }

    override fun getAllPartOfCustomMixesById(customMixId: Int): Flow<List<PartOfCustomMix>> {
        return partOfCustomMixDao.getAllPartOfCustomMixesById(customMixId = customMixId)
    }

    override suspend fun getCustomMixById(customMixId: Int): CustomMix {
        return partOfCustomMixDao.getCustomMixById(customMixId = customMixId)
    }

    override suspend fun getPartOfCustomMixById(partOfMixId: Int): PartOfCustomMix {
        return partOfCustomMixDao.getPartOfCustomMixById(partOfMixId = partOfMixId)
    }

}