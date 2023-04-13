package com.example.gym.ui.presentation.exercise_screen.screens.exercise_list_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ExerciseListItem(
    text: String,
    type: Int,
    deleteExerciseFromDatabase: () -> Unit,
    deleteExerciseFromRemote: () -> Unit
) {
    Row {
        Text(text = text);
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = null,
            modifier = Modifier.clickable { deleteExerciseFromDatabase() })
        Icon(
            imageVector = Icons.Default.DeleteForever,
            contentDescription = null,
            modifier = Modifier.clickable { deleteExerciseFromRemote() })
    }
}