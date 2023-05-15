package com.example.gym.ui.presentation.login_screen.screens.login_screen.view_models

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gym.R
import com.example.gym.data.remote.model.request.UserLoginRemote
import com.example.gym.domain.fetching_status.FetchingStatus
import com.example.gym.domain.use_cases.login_screen.LoginUseCase
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
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val application: Application
) : ViewModel() {


    private val _loginState = MutableStateFlow(LoginState())
    val loginState = _loginState.asStateFlow()

    var wasLoggedOnce by mutableStateOf(false)
        private set

    fun setPassword(password: String) {
        _loginState.update { currentState ->
            currentState.copy(password = password)
        }
    }

    fun setUsername(username: String) {
        if(username.length >= 25) return
        _loginState.update { currentState ->
            currentState.copy(username = username)
        }
    }

    fun setError(errorMessage:String){
        _loginState.update { currentState ->
            currentState.copy(result = FetchingStatus.Error(errorMessage))
        }
    }

    fun login() {
        wasLoggedOnce = true
        if(_loginState.value.password.isEmpty() || _loginState.value.username.isEmpty()){
            _loginState.update { currentState ->
                currentState.copy(result = FetchingStatus.Error(application.getString(R.string.input_not_filled)))
            }
            return
        }
        viewModelScope.launch {
            try {
                loginUseCase(UserLoginRemote(loginState.value.username,loginState.value.password))
                _loginState.update { currentState ->
                    currentState.copy(result = FetchingStatus.Success)
                }
            }catch (e:IOException){
                _loginState.update { currentState ->
                    currentState.copy(result = FetchingStatus.Error(application.getString(R.string.internet_error)))
                }
            } catch (e:HttpException){
                _loginState.update { currentState ->
                    currentState.copy(result = FetchingStatus.Error(application.getString(R.string.incorrect_login)))
                }
            }
        }
    }
}