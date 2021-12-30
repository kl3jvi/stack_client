package com.kl3jvi.stackclient.data.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class UsersDto(
    @field:Json(name = "has_more")
    val hasMore: Boolean,
    @field:Json(name = "items")
    val items: List<ItemDto>,
    @field:Json(name = "quota_max")
    val quotaMax: Int,
    @field:Json(name = "quota_remaining")
    val quotaRemaining: Int
):Parcelable