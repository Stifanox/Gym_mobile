package com.example.gym.cycle_feature.ui.screens.training_editor_screen.components

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.gym.data.database.model.ExerciseDatabase
import com.example.gym.data.database.model.TrainingDayDatabase

@Composable
fun ExerciseItemEditor(
    exerciseList: List<ExerciseDatabase>,
    trainingData: TrainingDayDatabase
) {

    var isDropdownVisible by rememberSaveable { mutableStateOf(false) }
    var selectedExercise by rememberSaveable {
        mutableStateOf(
            exerciseList.find { it.id == trainingData.exerciseId }?.exerciseName ?: "None"
        )
    }
    Row(modifier = Modifier.fillMaxWidth()) {
        TextField(
            value = trainingData.reps.toString(),
            onValueChange = {},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.width(50.dp)
        )
        Text(text = "x")
        TextField(
            value = trainingData.sets.toString(),
            onValueChange = {},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.width(50.dp)
        )
        Text(text = selectedExercise)

        DropdownMenu(
            expanded = isDropdownVisible,
            onDismissRequest = { isDropdownVisible = false },
        ) {
            exerciseList.forEach {
                DropdownMenuItem(onClick = { selectedExercise = it.exerciseName }) {
                    Text(text = it.exerciseName.replaceFirstChar { it.uppercase() })

                }
            }
        }

        Button(onClick = {
            isDropdownVisible = true
            Log.d(
                "isVisible",
                isDropdownVisible.toString()
            )
        }) {
            Text(text = "Show dropdown")
        }
    }


}