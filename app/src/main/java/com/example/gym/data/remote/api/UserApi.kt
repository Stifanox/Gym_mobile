package com.example.gym.data.remote.api

import com.example.gym.data.remote.model.request.TokenRemote
import com.example.gym.data.remote.model.request.UserAddRemote
import com.example.gym.data.remote.model.request.UserLoginRemote
import com.example.gym.data.remote.model.response.ResponseRemote
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("$PREFIX_USER/register")
    suspend fun registerUser(@Body user:UserAddRemote):ResponseRemote<String>

    //FIXME: there is bug here will crush if login is not successful
    @POST("$PREFIX_USER/login")
    suspend fun loginUser(@Body user: UserLoginRemote):ResponseRemote<TokenRemote>
}