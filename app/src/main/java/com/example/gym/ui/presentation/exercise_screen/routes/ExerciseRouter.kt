package com.example.gym.ui.presentation.exercise_screen.routes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.gym.ui.presentation.exercise_screen.routes.ExerciseRoutes
import com.example.gym.ui.presentation.exercise_screen.screens.exercise_list_screen.components.ExerciseListScreen

fun NavGraphBuilder.exerciseGraph(navController: NavController){
    navigation(startDestination = ExerciseRoutes.ExerciseList.route, route = ExerciseRoutes.PREFIX.route){
        composable(ExerciseRoutes.ExerciseList.route){
            ExerciseListScreen()
        }
    }
}