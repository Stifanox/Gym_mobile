package com.example.gym.ui.presentation.main_screen.screens.home_screen.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import com.example.gym.domain.token.TokenManagerSharedPreferences


@Composable
fun HomeScreen() {
    val context = LocalContext.current
    Text(text = TokenManagerSharedPreferences.getTokenFromSharedPreferences(context))
}