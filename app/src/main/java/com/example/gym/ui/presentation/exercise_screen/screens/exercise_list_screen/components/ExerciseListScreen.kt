package com.example.gym.ui.presentation.exercise_screen.screens.exercise_list_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gym.ui.presentation.exercise_screen.screens.exercise_list_screen.view_models.ExerciseListViewModel
import java.util.*

@Composable
fun ExerciseListScreen(
    exerciseListViewModel: ExerciseListViewModel = hiltViewModel()
) {
    val state by exerciseListViewModel.exerciseState.collectAsState(initial = listOf())


    if (state.isEmpty()) {
        Column {
            Button(onClick = { exerciseListViewModel.fetchNewData() }) {
                Text(text = "Fetch")
            }

            Text(text = "There is no exercises found. Fetch it from remote source or add new one.")
        }
        return
    }

    LazyColumn {
        item {
            Button(onClick = { exerciseListViewModel.fetchNewData() }) {
                Text(text = "Fetch")
            }
        }
        items(state) { exercise ->
            ExerciseListItem(
                text = exercise.exerciseName.replaceFirstChar { char -> char.uppercase() },
                type = exercise.exerciseType,
                deleteExerciseFromDatabase = {
                    exerciseListViewModel.deleteExerciseFromDatabase(
                        exercise
                    )
                },
                deleteExerciseFromRemote = { exerciseListViewModel.deleteExerciseFromRemote(exercise) }
            )
        }
    }

}

