package com.example.gym.cycle_feature.ui.screens.training_editor_screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.gym.data.database.model.TrainingDayWithName

@Composable
fun ExerciseItemEditor(
    exercise:TrainingDayWithName
) {
    Row {
        Text(text = exercise.exercise.exerciseName)
        Text(text = exercise.trainingDay.weight.toString())
        Text(text = exercise.trainingDay.reps.toString())
        Text(text = exercise.trainingDay.sets.toString())
    }
}