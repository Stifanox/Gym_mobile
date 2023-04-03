package com.example.gym.ui.presentation.main_screen.screens.home_screen.common_files

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItemData(
    @StringRes val text: Int,
    val icon: ImageVector,
    val action: () -> Unit
)
