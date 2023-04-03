package com.example.gym.ui.presentation.login_screen.screens.register_screen.view_models

import android.app.Application
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gym.R
import com.example.gym.data.remote.model.StatusRemote
import com.example.gym.data.remote.model.request.UserAddRemote
import com.example.gym.domain.use_cases.register_screen.RegisterUseCase
import com.example.gym.ui.presentation.login_screen.screens.common_classes.ResponseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase,
    private val application: Application
) : ViewModel() {
    private val _registerState = MutableStateFlow(RegisterState())
    val registerState = _registerState.asStateFlow()

    var wasRegisteredOnce by mutableStateOf(false)
        private set

    fun setPassword(password: String) {
        _registerState.update { currentState ->
            currentState.copy(password = password)
        }
    }

    fun setUsername(username: String) {
        if (username.length >= 25) return
        _registerState.update { currentState ->
            currentState.copy(username = username)
        }
    }

    fun setPasswordAgain(password: String) {
        _registerState.update { currentState ->
            currentState.copy(passwordAgain = password)
        }
    }

    fun setEmail(email: String) {
        _registerState.update { currentState ->
            currentState.copy(email = email)
        }
    }

        fun registerUser() {
            wasRegisteredOnce = true
            val (username, password, passwordAgain, email) = _registerState.value

            val isValidInputs = checkInputs(username,password,passwordAgain,email)
            if(!isValidInputs) return

            viewModelScope.launch {
                try {
                    val response = registerUseCase(
                        UserAddRemote(
                            username = username,
                            password = password,
                            email = email
                        )
                    )

                    when (response.status) {
                        StatusRemote.Error.status -> {
                            _registerState.update { currentState ->
                                currentState.copy(result = ResponseResult.Error(application.getString(R.string.username_or_mail_taken)))
                            }
                        }
                        StatusRemote.Success.status -> {
                            _registerState.update { currentState ->
                                currentState.copy(result = ResponseResult.Success)
                            }
                        }
                    }
                } catch (e: IOException) {
                    _registerState.update { currentState ->
                        currentState.copy(result = ResponseResult.Error(application.getString(R.string.internet_error)))
                    }
                } catch (e: HttpException) {
                    //TODO: Think how to implement this because server doesn't return 403 code so it won't happened
                    _registerState.update { currentState ->
                        currentState.copy(result = ResponseResult.Error("xd"))
                    }
                }
            }
        }

    private fun checkInputs(
        username: String,
        password: String,
        passwordAgain: String,
        email: String
    ): Boolean {
        if (passwordAgain.isEmpty() || password.isEmpty() || username.isEmpty() || email.isEmpty()) {
            _registerState.update { currentState ->
                currentState.copy(result = ResponseResult.Error(application.getString(R.string.input_not_filled)))
            }
            return false
        }
        if (passwordAgain != password) {
            _registerState.update { currentState ->
                currentState.copy(result = ResponseResult.Error(application.getString(R.string.passwords_not_same)))
            }
            return false
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            _registerState.update { currentState ->
                currentState.copy(result = ResponseResult.Error(application.getString(R.string.invalid_email)))
            }
            return false
        }
        return true
    }
}