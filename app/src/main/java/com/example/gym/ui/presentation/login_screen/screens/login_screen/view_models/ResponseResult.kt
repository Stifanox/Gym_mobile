package com.example.gym.ui.presentation.login_screen.screens.login_screen.view_models

sealed class ResponseResult {
    data class Error(var error: String): ResponseResult()
    object Success: ResponseResult()
    object InProgress: ResponseResult()
}