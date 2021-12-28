package com.kl3jvi.stackclient.data.repository

import androidx.annotation.MainThread
import com.kl3jvi.stackclient.common.Constants.ASC_ORDER_TYPE
import com.kl3jvi.stackclient.common.Constants.SORT_BY_REPUTATION
import com.kl3jvi.stackclient.common.Constants.STACK_TYPE
import com.kl3jvi.stackclient.common.Resource
import com.kl3jvi.stackclient.data.model.ItemDto
import com.kl3jvi.stackclient.data.network.UsersService
import com.kl3jvi.stackclient.data.persistence.UsersDao
import com.kl3jvi.stackclient.domain.repository.UserRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject


@ExperimentalCoroutinesApi
class DefaultUserRepository @Inject constructor(
    private val usersDao: UsersDao,
    private val usersService: UsersService
) : UserRepository {

    /**
     * Fetched the users from network and stored it in database. At the end, data from persistence
     * storage is fetched and emitted.
     */
    override fun getAllUsers(): Flow<Resource<List<ItemDto>>> {
        return object : NetworkBoundRepository<List<ItemDto>, List<ItemDto>>() {

            override suspend fun saveRemoteData(response: List<ItemDto>) =
                usersDao.addUsers(response)

            override fun fetchFromLocal(): Flow<List<ItemDto>> = usersDao.getAllUsers()

            override suspend fun fetchFromRemote(): Response<List<ItemDto>> =
                usersService.getUsers(
                    orderType = ASC_ORDER_TYPE,
                    sortBy = SORT_BY_REPUTATION,
                    site = STACK_TYPE,
                    page = 1
                )
        }.asFlow()
    }

    /**
     * Retrieves a user with specified [userId].
     * @param userId Unique id of a [ItemDto].
     * @return [ItemDto] data fetched from the database.
     */
    @MainThread
    override fun getUserById(userId: Int): Flow<Resource<ItemDto>> {
        return object : NetworkBoundRepository<ItemDto, ItemDto>() {

            override suspend fun saveRemoteData(response: ItemDto) =
                usersDao.addUser(response)

            override fun fetchFromLocal(): Flow<ItemDto> = usersDao.getUserById(userId = userId)

            override suspend fun fetchFromRemote(): Response<ItemDto> =
                usersService.getUserById(
                    userId = userId,
                    site = STACK_TYPE,
                )
        }.asFlow()
    }
}
