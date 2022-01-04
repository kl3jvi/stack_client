package com.kl3jvi.stackclient.data.model

import android.os.Parcelable
import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Entity
@JsonClass(generateAdapter = true)
@Parcelize
data class CollectivesDto(
    @Json(name = "collective")
    val collective: CollectiveDto,
    @Json(name = "role")
    val role: String
) : Parcelable