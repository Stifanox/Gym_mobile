package com.example.gym.cycle_feature.ui.screens.training_editor_screen.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.gym.cycle_feature.ui.screens.training_editor_screen.view_models.TrainingData
import com.example.gym.data.database.model.ExerciseDatabase
import com.example.gym.data.database.model.TrainingDayDatabase

//TODO: make it reusable
@Composable
fun ExerciseItemEditor(
    exerciseList: List<ExerciseDatabase>,
    trainingData: TrainingData,
    setReps: (String, Int) -> Unit,
    setSets: (String, Int) -> Unit,
    setExercise: (Int, Int) -> Unit,
    setWeight: (Int, Int) -> Unit
) {

    var isDropdownVisible by rememberSaveable { mutableStateOf(false) }
    var selectedExercise by rememberSaveable {
        mutableStateOf(
            "XDDD"
        )
    }

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        TextField(
            value = trainingData.reps,
            onValueChange = { setReps(it, trainingData.idOfItem) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.width(50.dp)
        )
        Text(text = "x")
        TextField(
            value = trainingData.sets,
            onValueChange = { setSets(it, trainingData.idOfItem) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.width(50.dp)
        )
        Text(text = selectedExercise)

        DropdownMenu(
            expanded = isDropdownVisible,
            onDismissRequest = { isDropdownVisible = false },
        ) {
            exerciseList.forEach {
                DropdownMenuItem(onClick = {
                    selectedExercise = it.exerciseName
                    isDropdownVisible = false
                }) {
                    Text(text = it.exerciseName.replaceFirstChar { it.uppercase() })

                }
            }
        }

        Button(onClick = {
            isDropdownVisible = true
        }) {
            Text(text = "Show dropdown")
        }
    }


}