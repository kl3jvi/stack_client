package com.kl3jvi.stackclient.data.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class CollectivesDto(
    @Json(name = "collective")
    val collective: CollectiveDto,
    @Json(name = "role")
    val role: String
) : Parcelable