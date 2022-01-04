package com.kl3jvi.stackclient.data.persistence.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.kl3jvi.stackclient.data.model.BadgeCountsDto
import com.squareup.moshi.Moshi
import javax.inject.Inject

@ProvidedTypeConverter
class BadgeConverter @Inject constructor(
    private val moshi: Moshi
) {

    @TypeConverter
    fun fromBadgeConverter(data: BadgeCountsDto): String {
        return moshi.adapter(BadgeCountsDto::class.java).toJson(data)
    }

    @TypeConverter
    fun toBadgeConverter(json: String): BadgeCountsDto? {
        return moshi.adapter(BadgeCountsDto::class.java).fromJson(json)
    }
}

