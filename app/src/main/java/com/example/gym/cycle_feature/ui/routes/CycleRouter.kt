package com.example.gym.cycle_feature.ui.routes

import android.util.Log
import androidx.navigation.*
import androidx.navigation.compose.composable
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
                navController.navigate(CycleRoutes.CycleAddRoute.route) {
                    launchSingleTop = true
                    popUpTo(CycleRoutes.HomeRoute.route)
                }
            })
        }
        composable(route = "${CycleRoutes.TrainingEditorRoute.route}/{nameOfCycle}",
            arguments = listOf(navArgument("nameOfCycle") { type = NavType.StringType })
        ) {
            TrainingEditor(it.arguments?.getString("nameOfCycle"))
        }

        composable(route = CycleRoutes.CycleAddRoute.route) {
            CycleAddScreen({nameOfCycle ->
                navController.navigate("${CycleRoutes.TrainingEditorRoute.route}/$nameOfCycle") {
                    launchSingleTop = true
                    popUpTo(CycleRoutes.HomeRoute.route)
                }
            })
        }
    }
}