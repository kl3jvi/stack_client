package com.kl3jvi.stackclient.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kl3jvi.stackclient.data.model.BadgeCountsDto
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Item(
    @PrimaryKey
    val userId: Int,
    val name: String,
    val profileImage: String,
    val reputation: Int,
    val badgeCounts: BadgeCountsDto,
    val location: String,
    val creationDate: Int
) : Parcelable
