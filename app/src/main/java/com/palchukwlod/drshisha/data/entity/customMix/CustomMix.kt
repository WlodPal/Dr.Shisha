package com.palchukwlod.drshisha.data.entity.customMix

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.palchukwlod.drshisha.utils.Constants.DATABASE_TABLE
import com.palchukwlod.drshisha.utils.Constants.PERCENTAGE_MAX
import com.palchukwlod.drshisha.utils.Constants.UNDEFINED_ID

@Entity(tableName = DATABASE_TABLE)
data class CustomMix(
    @PrimaryKey(autoGenerate = true)
    val customMixId: Int = UNDEFINED_ID,
    val mixName: String,
    val description: String,
    val levelOfStrong: LevelOfStrong,
    val percentage: Int = PERCENTAGE_MAX,
    val flavorType: List<FlavorType>,
)
