package com.example.gym.domain.use_cases.login_screen

import android.app.Application
import android.content.Context
import com.example.gym.R
import com.example.gym.data.remote.model.request.UserLoginRemote
import com.example.gym.domain.repository.remote.UserRepository
import javax.inject.Inject


class LoginUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val application: Application
) {

    suspend operator fun invoke(user: UserLoginRemote) {
        val response = userRepository.loginUser(user)
        //FIXME: wyrzucić do do innej funkcji
        val shared = application.getSharedPreferences(
            application.getString(R.string.shared_preferences_token),
            Context.MODE_PRIVATE
        )
        shared.edit().also {
            it.putString(application.getString(R.string.token), response.data.token)
            it.putString(application.getString(R.string.token_refresh), response.data.tokenRefresh)
            it.apply()
        }
    }
}