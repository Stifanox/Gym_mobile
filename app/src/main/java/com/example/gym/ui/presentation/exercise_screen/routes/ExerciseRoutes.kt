package com.example.gym.ui.presentation.exercise_screen.routes

sealed class ExerciseRoutes(val route:String) {
    object PREFIX: ExerciseRoutes("mainExerciseRoute")
    object ExerciseList:ExerciseRoutes("listExerciseRoute")
}
