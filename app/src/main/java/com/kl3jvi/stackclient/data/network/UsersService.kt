package com.kl3jvi.stackclient.data.network

import com.kl3jvi.stackclient.common.Constants.ALL_USERS_QUERY
import com.kl3jvi.stackclient.common.Constants.BASE_URL
import com.kl3jvi.stackclient.common.Constants.ORDER
import com.kl3jvi.stackclient.common.Constants.PAGE
import com.kl3jvi.stackclient.common.Constants.SITE
import com.kl3jvi.stackclient.common.Constants.SORT
import com.kl3jvi.stackclient.common.Constants.SPECIFIC_USER_QUERY
import com.kl3jvi.stackclient.data.model.ItemDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UsersService {
    @GET(BASE_URL + ALL_USERS_QUERY)
    suspend fun getUsers(
        @Query(ORDER) orderType: String,
        @Query(SORT) sortBy: String,
        @Query(SITE) site: String,
        @Query(PAGE) page: Int
    ): Response<List<ItemDto>>

    @GET(BASE_URL + SPECIFIC_USER_QUERY)
    suspend fun getUserById(
        @Path("userId") userId: Int,
        @Query(SITE) site: String
    ): Response<ItemDto>
}