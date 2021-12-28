package com.kl3jvi.stackclient.di

import com.kl3jvi.stackclient.data.network.UsersService
import com.kl3jvi.stackclient.data.persistence.UsersDao
import com.kl3jvi.stackclient.data.repository.DefaultUserRepository
import com.kl3jvi.stackclient.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.ExperimentalCoroutinesApi

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @ExperimentalCoroutinesApi
    @Provides
    @ViewModelScoped
    fun provideDefaultRepository(
        usersDao: UsersDao,
        usersService: UsersService
    ): UserRepository {
        return DefaultUserRepository(usersDao, usersService)
    }

}