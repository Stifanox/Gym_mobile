package com.example.gym.data.remote.repository

import com.example.gym.data.remote.api.UserApi
import com.example.gym.data.remote.model.request.UserAddRemote
import com.example.gym.data.remote.model.request.UserLoginRemote
import com.example.gym.data.remote.model.response.ResponseRemote
import com.example.gym.domain.repository.remote.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi
):UserRepository {
    override suspend fun registerUser(user: UserAddRemote): ResponseRemote<String> = userApi.registerUser(user)

    override suspend fun loginUser(user: UserLoginRemote): ResponseRemote<String> = userApi.loginUser(user)
}