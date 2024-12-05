package com.palchukwlod.drshisha.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.palchukwlod.drshisha.data.dao.CustomMixDao
import com.palchukwlod.drshisha.data.dao.PartOfCustomMixDao
import com.palchukwlod.drshisha.data.entity.customMix.CustomMix
import com.palchukwlod.drshisha.data.entity.customMix.PartOfCustomMix
import com.palchukwlod.drshisha.data.entity.customMix.converters.FlavourTypeConverter
import com.palchukwlod.drshisha.utils.Constants.DB_VERSION

@TypeConverters(FlavourTypeConverter::class)
@Database(
    entities = [CustomMix::class, PartOfCustomMix::class],
    version = DB_VERSION
)
abstract class MainDB : RoomDatabase() {

    abstract val customMixDao: CustomMixDao
    abstract val partOfCustomMixDao: PartOfCustomMixDao

}