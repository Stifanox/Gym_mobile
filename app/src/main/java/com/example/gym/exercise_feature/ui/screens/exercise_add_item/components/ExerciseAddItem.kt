package com.example.gym.exercise_feature.ui.screens.exercise_add_item.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gym.R
import com.example.gym.exercise_feature.ui.screens.exercise_add_item.view_models.ExerciseAddItemViewModel

//FIXME: Maybe lift this class to other file

sealed class ExerciseType(type: Int) {
    data class WITH_WEIGHT(val type: Int = 1) : ExerciseType(type)
    data class WITHOUT_WEIGHT(val type: Int = 2) : ExerciseType(type)
    data class WITH_TIME(val type: Int = 3) : ExerciseType(type)
}

@Composable
fun ExerciseAddItem(
    navigateToExerciseListScreen: () -> Unit,
    exerciseAddItemViewModel: ExerciseAddItemViewModel = hiltViewModel()
) {
    val exerciseState by exerciseAddItemViewModel.exerciseState.collectAsState()
    var isContextMenuVisible by rememberSaveable {
        mutableStateOf(false)
    }
    Column() {
        TextField(
            value = exerciseState.exerciseName,
            onValueChange = { exerciseAddItemViewModel.setExerciseName(it) })
        //TODO:Change to by on right place
        DropdownMenu(
            expanded = isContextMenuVisible,
            onDismissRequest = { isContextMenuVisible = false }) {
            DropdownMenuItem(onClick = { exerciseAddItemViewModel.setExerciseType(ExerciseType.WITH_WEIGHT().type) }) {
                Text(text = stringResource(R.string.with_weight))
            }
            DropdownMenuItem(onClick = { exerciseAddItemViewModel.setExerciseType(ExerciseType.WITHOUT_WEIGHT().type) }) {
                Text(text = stringResource(R.string.without_weight))
            }
            DropdownMenuItem(onClick = { exerciseAddItemViewModel.setExerciseType(ExerciseType.WITH_TIME().type) }) {
                Text(text = stringResource(R.string.with_time))
            }
        }
        Button(onClick = {
            exerciseAddItemViewModel.addItemToDatabase()
            navigateToExerciseListScreen()
        }) {
            Text(text = "Add Item To Database")
        }
        Button(onClick = {
            exerciseAddItemViewModel.addItemToRemote()
            navigateToExerciseListScreen()
        }) {
            Text(text = "Add Item To Remote")
        }
        Button(onClick = {
            exerciseAddItemViewModel.addItemToRemoteAndDatabase()
            navigateToExerciseListScreen()
        }) {
            Text(text = "Add Item To Database and Remote")
        }
        Button(onClick = {
            isContextMenuVisible = true
        }) {
            Text(text = "Show dropdown")
        }
        Text(text = exerciseState.exerciseName)
        Text(text = exerciseState.type.toString())
    }
}


