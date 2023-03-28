package com.example.gym.ui.presentation.login_screen.screens.register_screen.view_models

import com.example.gym.ui.presentation.login_screen.screens.common_classes.ResponseResult

data class RegisterState(
    val username:String = "",
    val password:String = "",
    val passwordAgain:String = "",
    val email:String = "",
    val result:ResponseResult = ResponseResult.InProgress
)