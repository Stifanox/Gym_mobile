package com.example.gym.ui.presentation.login_screen.screens.login_screen.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gym.R
import com.example.gym.ui.presentation.login_screen.screens.login_screen.view_models.LoginViewModel
import com.example.gym.ui.presentation.login_screen.screens.common_classes.ResponseResult

@Composable
fun LoginScreen(
    navigateToHomeScreen: () -> Unit,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    val loginState by loginViewModel.loginState.collectAsState()

    LaunchedEffect(key1 = loginState.result) {
        if (loginState.result is ResponseResult.Error) {
            Toast.makeText(
                context,
                (loginState.result as ResponseResult.Error).error,
                Toast.LENGTH_SHORT
            ).show()
            loginViewModel.setError((loginState.result as ResponseResult.Error).error)
        } else if (loginState.result is ResponseResult.Success) {
            navigateToHomeScreen()
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            label = @Composable { Text(text = stringResource(R.string.username)) },
            singleLine = true,
            isError = loginState.username.isEmpty() && loginViewModel.wasLoggedOnce,
            maxLines = 1,
            placeholder = {
                Text(
                    fontSize = 12.sp,
                    text = stringResource(R.string.enter_username)
                )
            },
            value = loginState.username,
            onValueChange = { loginViewModel.setUsername(it) },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            label = @Composable { Text(text = stringResource(R.string.password_text)) },
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            isError = loginState.password.isEmpty() && loginViewModel.wasLoggedOnce,
            placeholder = {
                Text(
                    fontSize = 12.sp,
                    text = stringResource(R.string.enter_password)
                )
            },
            value = loginState.password,
            onValueChange = { loginViewModel.setPassword(it) },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                    loginViewModel.login()
                }
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            focusManager.clearFocus()
            loginViewModel.login()
        }) {
            Text(text = stringResource(id = R.string.login))
        }
    }
}