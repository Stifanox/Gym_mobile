package com.example.gym.main_screen_feature.ui.routes

import androidx.compose.foundation.layout.Box
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.gym.main_screen_feature.ui.screens.home_screen.components.HomeScreen

fun NavGraphBuilder.mainGraph(navController: NavController){
    navigation(MainRoutes.HomeRoute.route, MainRoutes.PREFIX.route){
        composable(MainRoutes.HomeRoute.route){
            HomeScreen()
        }
    }

}