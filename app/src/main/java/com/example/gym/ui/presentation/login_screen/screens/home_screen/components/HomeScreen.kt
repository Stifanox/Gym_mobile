package com.example.gym.ui.presentation.login_screen.screens.home_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.gym.R

@Composable
fun HomeScreen(
    navigateToLoginScreen: () -> Unit,
    navigateToRegisterScreen: () -> Unit,
    navigateToMainScreen: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navigateToLoginScreen() }) { Text(text = stringResource(R.string.login)) }
        Spacer(modifier = Modifier.padding(8.dp))

        Button(onClick = { navigateToRegisterScreen() }) { Text(text = stringResource(R.string.register)) }
        Spacer(modifier = Modifier.padding(8.dp))

        Button(onClick = { navigateToMainScreen() }) { Text(text = stringResource(R.string.continue_without_login)) }
    }
}