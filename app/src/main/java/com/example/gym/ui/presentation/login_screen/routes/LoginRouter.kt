package com.example.gym.ui.presentation.login_screen.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.gym.ui.presentation.login_screen.screens.home_screen.components.HomeScreen
import com.example.gym.ui.presentation.login_screen.screens.login_screen.components.LoginScreen
import com.example.gym.ui.presentation.login_screen.screens.register_screen.components.RegisterScreen
import com.example.gym.ui.presentation.main_screen.routes.MainRoutes

fun NavGraphBuilder.loginGraph(navController: NavController) {
    navigation(
        startDestination = LoginRoutes.HomeRoute.route,
        route = LoginRoutes.PREFIX.route
    ) {
        composable(LoginRoutes.HomeRoute.route) {
            HomeScreen(
                navigateToLoginScreen = { navController.navigate(LoginRoutes.LoginRoute.route) },
                navigateToRegisterScreen = { navController.navigate(LoginRoutes.RegisterRoute.route) },
                navigateToMainScreen = { navController.navigate(MainRoutes.HomeRoute.route){
                    popUpTo(LoginRoutes.HomeRoute.route){inclusive=true}
                } }
            )
        }
        composable(LoginRoutes.LoginRoute.route) {
            LoginScreen({
                navController.navigate(MainRoutes.HomeRoute.route) {
                    popUpTo(LoginRoutes.HomeRoute.route){inclusive = true}
                }
            })
        }
        composable(LoginRoutes.RegisterRoute.route){
            //TODO:check if it work
            RegisterScreen({navController.navigate(LoginRoutes.LoginRoute.route){
                popUpTo(LoginRoutes.HomeRoute.route)
            } })
        }
    }
}