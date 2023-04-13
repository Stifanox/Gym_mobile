package com.example.gym.ui.presentation.home_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.gym.R
import com.example.gym.domain.token.TokenManagerSharedPreferences

@Composable
fun HomeScreen(
    navigateToLoginScreen: () -> Unit,
    navigateToRegisterScreen: () -> Unit,
    navigateToMainScreen: () -> Unit
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navigateToLoginScreen() }) { Text(text = stringResource(R.string.login)) }
        Spacer(modifier = Modifier.padding(8.dp))

        Button(onClick = { navigateToRegisterScreen() }) { Text(text = stringResource(R.string.register)) }
        Spacer(modifier = Modifier.padding(8.dp))

        Button(onClick = {
            navigateToMainScreen()
            TokenManagerSharedPreferences.saveTokenToSharedPreferences(context,"dummy","dummy")
        }) { Text(text = stringResource(R.string.continue_without_login)) }
    }
}