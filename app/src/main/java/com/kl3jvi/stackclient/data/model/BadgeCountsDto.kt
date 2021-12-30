package com.kl3jvi.stackclient.data.model


import android.os.Parcelable
import androidx.room.Embedded
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class BadgeCountsDto(
    @field:Json(name = "bronze")
    val bronze: Int,
    @field:Json(name = "gold")
    val gold: Int,
    @field:Json(name = "silver")
    val silver: Int
) : Parcelable