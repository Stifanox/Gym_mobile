package com.example.gym.ui.presentation.login_screen.screens.common_classes
//FIXME: Maybe change a name of this class (maybe?)
sealed class ResponseResult {
    data class Error(var error: String): ResponseResult()
    object Success: ResponseResult()
    object InProgress: ResponseResult()
}