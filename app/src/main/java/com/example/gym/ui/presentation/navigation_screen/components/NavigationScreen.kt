package com.example.gym.ui.presentation.navigation_screen.components

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.gym.R
import com.example.gym.ui.presentation.login_screen.routes.LoginRoutes
import com.example.gym.ui.presentation.login_screen.routes.loginGraph
import com.example.gym.ui.presentation.main_screen.routes.MainRoutes
import com.example.gym.ui.presentation.main_screen.routes.mainGraph

@Composable
fun NavigationScreen() {
    //TODO: To be implemented later
//    val token = LocalContext.current.getSharedPreferences(
//        stringResource(id = R.string.shared_preferences_token) ,
//        Context.MODE_PRIVATE
//    ).getString(stringResource(R.string.token),"")
//
//    val startRoute = if (token.isNullOrBlank()){
//        LoginRoutes.PREFIX.route
//    }else{
//        MainRoutes.PREFIX.route
//    }
//
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = LoginRoutes.PREFIX.route) {
            loginGraph(navController)
            mainGraph(navController)
        }
}