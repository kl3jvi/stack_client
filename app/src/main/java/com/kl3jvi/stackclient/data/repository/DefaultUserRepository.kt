package com.kl3jvi.stackclient.data.repository

import androidx.annotation.MainThread
import com.kl3jvi.stackclient.common.Constants.DESC_ORDER_TYPE
import com.kl3jvi.stackclient.common.Constants.SORT_BY_REPUTATION
import com.kl3jvi.stackclient.common.Constants.STACK_TYPE
import com.kl3jvi.stackclient.common.Resource
import com.kl3jvi.stackclient.data.model.ItemDto
import com.kl3jvi.stackclient.data.model.UsersDto
import com.kl3jvi.stackclient.data.network.UsersService
import com.kl3jvi.stackclient.data.persistence.UsersDao
import com.kl3jvi.stackclient.domain.repository.UserRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
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
        return object : NetworkBoundRepository<List<ItemDto>, UsersDto>() {

            override suspend fun saveRemoteData(response: UsersDto) =
                usersDao.addUsers(response.items)

            override fun fetchFromLocal(): Flow<List<ItemDto>> = usersDao.getAllUsers()

            override suspend fun fetchFromRemote(): Response<UsersDto> =
                usersService.getUsers(
                    orderType = DESC_ORDER_TYPE,
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
    override fun getUserById(userId: Int): Flow<ItemDto> =
        usersDao.getUserById(userId).distinctUntilChanged()
}
