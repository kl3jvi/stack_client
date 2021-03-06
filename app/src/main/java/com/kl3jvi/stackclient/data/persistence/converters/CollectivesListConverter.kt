package com.kl3jvi.stackclient.data.persistence.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.kl3jvi.stackclient.data.model.CollectivesDto
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class CollectivesListConverter @Inject constructor(
    private val moshi: Moshi
) {

    @TypeConverter
    fun fromString(value: String): List<CollectivesDto>? {
        val listType = Types.newParameterizedType(List::class.java, CollectivesDto::class.java)
        val adapter: JsonAdapter<List<CollectivesDto>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromInfoType(type: List<CollectivesDto>?): String {
        val listType = Types.newParameterizedType(List::class.java, CollectivesDto::class.java)
        val adapter: JsonAdapter<List<CollectivesDto>> = moshi.adapter(listType)
        return adapter.toJson(type)
    }
}