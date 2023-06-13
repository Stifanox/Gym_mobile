package com.example.gym.exercise_feature.ui.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.gym.exercise_feature.ui.routes.ExerciseRoutes
import com.example.gym.exercise_feature.ui.screens.exercise_add_item.components.ExerciseAddItem
import com.example.gym.exercise_feature.ui.screens.exercise_list_screen.components.ExerciseListScreen

fun NavGraphBuilder.exerciseGraph(navController: NavController){
    navigation(startDestination = ExerciseRoutes.ExerciseList.route, route = ExerciseRoutes.PREFIX.route){
        composable(ExerciseRoutes.ExerciseList.route){
            ExerciseListScreen({
                navController.navigate(ExerciseRoutes.ExerciseAddItem.route)
            })
        }
        composable(ExerciseRoutes.ExerciseAddItem.route){
            ExerciseAddItem({
                navController.navigate(ExerciseRoutes.ExerciseList.route){
                    popUpTo(ExerciseRoutes.ExerciseList.route)
                    launchSingleTop = true
                }
            })
        }
    }
}