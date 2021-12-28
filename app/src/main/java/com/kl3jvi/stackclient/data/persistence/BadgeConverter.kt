package com.kl3jvi.stackclient.data.persistence

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.kl3jvi.stackclient.data.model.BadgeCountsDto
import com.kl3jvi.stackclient.data.model.CollectivesDto
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapter
import javax.inject.Inject

@ProvidedTypeConverter
class BadgeConverter @Inject constructor(
    private val moshi: Moshi
) {

    @TypeConverter
    fun fromString(value: String): BadgeCountsDto? {
        val objectType = Types.newParameterizedType(BadgeCountsDto::class.java)
        val adapter: JsonAdapter<BadgeCountsDto> = moshi.adapter(objectType)
        return adapter.fromJson(value)

    }

    @TypeConverter
    fun fromInfoType(type: BadgeCountsDto?): String {
        val objectType = Types.newParameterizedType(BadgeCountsDto::class.java)
        val adapter: JsonAdapter<BadgeCountsDto> = moshi.adapter(objectType)
        return adapter.toJson(type)
    }
}
