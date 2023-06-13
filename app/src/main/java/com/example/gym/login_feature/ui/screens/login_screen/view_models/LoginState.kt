package com.example.gym.login_feature.ui.screens.login_screen.view_models

import com.example.gym.domain.fetching_status.FetchingStatus


data class LoginState(
    val password:String = "",
    val username:String = "",
    val result: FetchingStatus = FetchingStatus.InProgress,
)

