package com.example.gym.main_screen_feature.ui.screens.home_screen.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.gym.main_screen_feature.ui.screens.home_screen.common_files.MenuItemData

@Composable
fun DrawerMenu(
    listOfItems: List<MenuItemData>
) {
    LazyColumn {
        items(listOfItems) {
            DrawerItem(text = it.text, icon = it.icon, action = it.action)
        }
    }
}