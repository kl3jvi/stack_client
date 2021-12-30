package com.kl3jvi.stackclient.data.persistence

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.kl3jvi.stackclient.data.model.CollectiveDto
import com.kl3jvi.stackclient.data.model.CollectivesDto
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class CollectiveConverter @Inject constructor(
    private val moshi: Moshi
) {

    @TypeConverter
    fun fromString(value: String): CollectiveDto? {
        val listType = Types.newParameterizedType(CollectiveDto::class.java)
        val adapter: JsonAdapter<CollectiveDto> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromInfoType(type: CollectiveDto?): String {
        val listType = Types.newParameterizedType(List::class.java, CollectiveDto::class.java)
        val adapter: JsonAdapter<CollectiveDto> = moshi.adapter(listType)
        return adapter.toJson(type)
    }
}

