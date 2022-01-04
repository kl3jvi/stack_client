package com.kl3jvi.stackclient.di

import android.app.Application
import androidx.room.Room
import com.kl3jvi.stackclient.common.Constants.TABLE_NAME
import com.kl3jvi.stackclient.data.persistence.AppDatabase
import com.kl3jvi.stackclient.data.persistence.UsersDao
import com.kl3jvi.stackclient.data.persistence.converters.BadgeConverter
import com.kl3jvi.stackclient.data.persistence.converters.CollectiveConverter
import com.kl3jvi.stackclient.data.persistence.converters.CollectivesListConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun providePokemonDao(appDatabase: AppDatabase): UsersDao {
        return appDatabase.usersDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application,
        badgeConverter: BadgeConverter,
        collectivesListConverter: CollectivesListConverter,
    ): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, TABLE_NAME)
            .fallbackToDestructiveMigration()
            .addTypeConverter(badgeConverter)
            .addTypeConverter(collectivesListConverter)
            .build()
    }
}