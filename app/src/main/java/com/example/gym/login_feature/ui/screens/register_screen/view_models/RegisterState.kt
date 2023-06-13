package com.example.gym.login_feature.ui.screens.register_screen.view_models

import com.example.gym.domain.fetching_status.FetchingStatus

data class RegisterState(
    val username:String = "",
    val password:String = "",
    val passwordAgain:String = "",
    val email:String = "",
    val result: FetchingStatus = FetchingStatus.InProgress
)