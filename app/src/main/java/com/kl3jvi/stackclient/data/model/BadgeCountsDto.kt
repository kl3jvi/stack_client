package com.kl3jvi.stackclient.data.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class BadgeCountsDto(
    @Json(name = "bronze")
    val bronze: Int,
    @Json(name = "gold")
    val gold: Int,
    @Json(name = "silver")
    val silver: Int
) : Parcelable