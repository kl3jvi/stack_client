package com.kl3jvi.stackclient.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kl3jvi.stackclient.data.model.ItemDto
import com.kl3jvi.stackclient.data.persistence.converters.BadgeConverter
import com.kl3jvi.stackclient.data.persistence.converters.CollectiveConverter
import com.kl3jvi.stackclient.data.persistence.converters.CollectivesListConverter

@Database(entities = [ItemDto::class], version = 1, exportSchema = false)
@TypeConverters(value = [CollectivesListConverter::class, BadgeConverter::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun usersDao(): UsersDao
}