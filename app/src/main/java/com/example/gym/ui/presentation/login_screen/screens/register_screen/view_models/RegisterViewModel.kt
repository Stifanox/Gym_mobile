package com.example.gym.ui.presentation.login_screen.screens.register_screen.view_models

import androidx.lifecycle.ViewModel
import com.example.gym.domain.use_cases.register_screen.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
):ViewModel() {
    private val _registerState = MutableStateFlow(RegisterState())
    val registerState = _registerState.asStateFlow()

    fun setPassword(password:String){
        _registerState.update { currentState ->
            currentState.copy(password = password)
        }
    }

    fun setUsername(username:String){
        _registerState.update { currentState ->
            currentState.copy(username = username)
        }
    }

    fun setPasswordAgain(password: String){
        _registerState.update { currentState ->
            currentState.copy(passwordAgain = password)
        }
    }
}