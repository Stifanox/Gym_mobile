package com.example.gym.cycle_feature.ui.screens.training_editor_screen.view_models

data class TrainingData(
    val idOfItem:Int,
    var trainingDay: Int = 0,
    var exerciseId: Int = 0,
    var weight: Int = 0,
    var reps: String = "0",
    var sets: String = "0",
    var order: Int = 0,
)