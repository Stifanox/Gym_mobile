package com.example.gym.exercise_feature.ui.routes

sealed class ExerciseRoutes(val route:String) {
    object PREFIX: ExerciseRoutes("mainExerciseRoute")
    object ExerciseList: ExerciseRoutes("listExerciseRoute")
    object ExerciseAddItem: ExerciseRoutes("addItemExerciseRoute")
}
