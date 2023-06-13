package com.example.gym.login_feature.ui.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.gym.home_feature.ui.components.HomeScreen
import com.example.gym.login_feature.ui.screens.login_screen.components.LoginScreen
import com.example.gym.login_feature.ui.screens.register_screen.components.RegisterScreen
import com.example.gym.main_screen_feature.ui.routes.MainRoutes

fun NavGraphBuilder.loginGraph(navController: NavController) {
    navigation(
        startDestination = LoginRoutes.HomeRoute.route,
        route = LoginRoutes.PREFIX.route
    ) {
        composable(LoginRoutes.HomeRoute.route) {
            HomeScreen(
                navigateToLoginScreen = { navController.navigate(LoginRoutes.LoginRoute.route) },
                navigateToRegisterScreen = { navController.navigate(LoginRoutes.RegisterRoute.route) },
                navigateToMainScreen = {
                    navController.navigate(MainRoutes.HomeRoute.route) {
                        popUpTo(LoginRoutes.HomeRoute.route) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }
        composable(LoginRoutes.LoginRoute.route) {
            LoginScreen({
                navController.navigate(MainRoutes.HomeRoute.route) {
                    popUpTo(LoginRoutes.HomeRoute.route) { inclusive = true }
                }
            })
        }
        composable(LoginRoutes.RegisterRoute.route) {
            RegisterScreen({
                navController.navigate(LoginRoutes.LoginRoute.route) {
                    popUpTo(LoginRoutes.HomeRoute.route)
                }
            })
        }
    }
}
//