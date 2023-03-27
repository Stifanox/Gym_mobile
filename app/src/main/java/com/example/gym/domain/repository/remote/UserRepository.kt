package com.example.gym.domain.repository.remote

import com.example.gym.data.remote.model.request.TokenRemote
import com.example.gym.data.remote.model.request.UserAddRemote
import com.example.gym.data.remote.model.request.UserLoginRemote
import com.example.gym.data.remote.model.response.ResponseRemote

interface UserRepository {
    suspend fun registerUser(user: UserAddRemote): ResponseRemote<String>

    suspend fun loginUser(user: UserLoginRemote):ResponseRemote<TokenRemote>
}