package com.example.gym.cycle_feature.ui.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.gym.cycle_feature.ui.screens.cycle_add_screen.components.CycleAddScreen
import com.example.gym.cycle_feature.ui.screens.cycle_manager_screen.componenets.CycleScreen
import com.example.gym.cycle_feature.ui.screens.training_editor_screen.components.TrainingEditor

fun NavGraphBuilder.cycleGraph(navController: NavController) {
    navigation(
        startDestination = CycleRoutes.HomeRoute.route,
        route = CycleRoutes.PREFIX.route
    ) {
        composable(route = CycleRoutes.HomeRoute.route) {
            CycleScreen({
                navController.navigate(CycleRoutes.CycleAddRoute.route){
                    launchSingleTop = true
                    popUpTo(CycleRoutes.HomeRoute.route)
                }
            })
        }
        composable(route = CycleRoutes.TrainingEditorRoute.route){
            TrainingEditor()
        }

        composable(route = CycleRoutes.CycleAddRoute.route){
            CycleAddScreen()
        }
    }
}