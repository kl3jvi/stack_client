package com.kl3jvi.stackclient.data.persistence

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.kl3jvi.stackclient.data.model.CollectiveDto
import com.squareup.moshi.Moshi
import javax.inject.Inject

@ProvidedTypeConverter
class CollectiveConverter @Inject constructor(
    private val moshi: Moshi
) {

    @TypeConverter
    fun fromCollectiveDto(data: CollectiveDto): String {
        return moshi.adapter(CollectiveDto::class.java).toJson(data)
    }

    @TypeConverter
    fun toCollectiveDto(json: String): CollectiveDto? {
        return moshi.adapter(CollectiveDto::class.java).fromJson(json)
    }
}