package com.palchukwlod.drshisha.data.entity.customMix.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.palchukwlod.drshisha.data.entity.customMix.FlavorType

class FlavourTypeConverter {

    @TypeConverter
    fun fromString(value: String): List<FlavorType> {
        val listType = object : TypeToken<List<FlavorType>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toString(list: List<FlavorType>): String {
        return Gson().toJson(list)
    }

}