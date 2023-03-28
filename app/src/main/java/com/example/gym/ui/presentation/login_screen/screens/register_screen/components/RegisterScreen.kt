package com.example.gym.ui.presentation.login_screen.screens.register_screen.components

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
import com.example.gym.ui.presentation.login_screen.screens.common_classes.ResponseResult
import com.example.gym.ui.presentation.login_screen.screens.register_screen.view_models.RegisterViewModel

@Composable
fun RegisterScreen(
    navigateToLogin:()->Unit,
    registerViewModel: RegisterViewModel = hiltViewModel()
) {
    val registerState by registerViewModel.registerState.collectAsState()

    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    LaunchedEffect(key1 = registerState.result) {
        if (registerState.result is ResponseResult.Error) {
            Toast.makeText(
                context,
                (registerState.result as ResponseResult.Error).error,
                Toast.LENGTH_SHORT
            ).show()
        }
        else if (registerState.result is ResponseResult.Success){
            navigateToLogin()
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //TODO: check if username on database have char limitation
        TextField(
            value = registerState.username,
            onValueChange = { registerViewModel.setUsername(it) },
            modifier = Modifier.fillMaxWidth(),
            label = @Composable { Text(text = stringResource(R.string.username)) },
            isError = registerState.username.isEmpty() && registerViewModel.wasRegisteredOnce,
            singleLine = true,
            maxLines = 1,
            placeholder = {
                Text(
                    fontSize = 12.sp,
                    text = stringResource(R.string.enter_username)
                )
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = registerState.password,
            isError = registerState.password.isEmpty() && registerViewModel.wasRegisteredOnce,
            onValueChange = { registerViewModel.setPassword(it) },
            modifier = Modifier.fillMaxWidth(),
            label = @Composable { Text(text = stringResource(R.string.password_text)) },
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            placeholder = {
                Text(
                    fontSize = 12.sp,
                    text = stringResource(R.string.enter_password)
                )
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = registerState.passwordAgain,
            isError = registerState.passwordAgain.isEmpty() && registerViewModel.wasRegisteredOnce,
            onValueChange = { registerViewModel.setPasswordAgain(it) },
            modifier = Modifier.fillMaxWidth(),
            label = @Composable { Text(text = stringResource(R.string.password_text)) },
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            placeholder = {
                Text(
                    fontSize = 12.sp,
                    text = stringResource(R.string.password_again)
                )
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = registerState.email,
            isError = registerState.email.isEmpty() && registerViewModel.wasRegisteredOnce,
            onValueChange = { registerViewModel.setEmail(it) },
            modifier = Modifier.fillMaxWidth(),
            label = @Composable { Text(text = stringResource(R.string.email)) },
            singleLine = true,
            placeholder = {
                Text(
                    fontSize = 12.sp,
                    text = "Enter email"
                )
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                    registerViewModel.registerUser()
                }
            )
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            focusManager.clearFocus()
            registerViewModel.registerUser()
        }) {
            Text(text = stringResource(id = R.string.register))
        }
    }
}