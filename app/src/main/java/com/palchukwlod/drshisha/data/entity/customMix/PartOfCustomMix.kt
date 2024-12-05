package com.palchukwlod.drshisha.data.entity.customMix

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.palchukwlod.drshisha.utils.Constants.PART_OF_MIX_DATABASE_TABLE
import com.palchukwlod.drshisha.utils.Constants.UNDEFINED_ID

@Entity(tableName = PART_OF_MIX_DATABASE_TABLE)
data class PartOfCustomMix(
    @PrimaryKey(autoGenerate = true)
    val partOfMixId : Int = UNDEFINED_ID,
    var percentage: Int,
    val brandName: String,
    val flavour: String,
    val customMixId: Int
)
