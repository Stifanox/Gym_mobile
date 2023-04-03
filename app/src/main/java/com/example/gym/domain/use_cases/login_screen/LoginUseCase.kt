package com.example.gym.domain.use_cases.login_screen

import android.app.Application
import android.content.Context
import com.example.gym.R
import com.example.gym.data.remote.model.request.UserLoginRemote
import com.example.gym.domain.repository.remote.UserRepository
import com.example.gym.domain.token.TokenManagerSharedPreferences.Companion.saveTokenToSharedPreferences
import javax.inject.Inject


class LoginUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val application: Application
) {

    suspend operator fun invoke(user: UserLoginRemote) {
        val response = userRepository.loginUser(user)
        saveTokenToSharedPreferences(application, response.data.token, response.data.tokenRefresh)
    }
}