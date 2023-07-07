package com.example.gym.cycle_feature.domain

import androidx.annotation.StringRes

data class FABActions(
    @StringRes val text: Int,
    val action: () -> Unit
)