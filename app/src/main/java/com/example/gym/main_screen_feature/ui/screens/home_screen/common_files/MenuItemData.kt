package com.example.gym.main_screen_feature.ui.screens.home_screen.common_files

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItemData(
    @StringRes val text: Int,
    val icon: ImageVector,
    val action: () -> Unit
)
