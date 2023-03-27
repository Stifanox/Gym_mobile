package com.example.gym.ui.presentation.login_screen.screens.login_screen.view_models

data class LoginState(
    val password:String = "",
    val username:String = "",
    val result:ResponseResult = ResponseResult.InProgress
)
