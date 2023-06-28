package com.example.gym.exercise_feature.ui.screens.exercise_list_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.gym.domain.connection.ConnectivityObserver

@Composable
fun ExerciseListItem(
    text: String,
    type: Int,
    deleteExerciseFromDatabase: () -> Unit,
    deleteExerciseFromRemote: () -> Unit,
    isConnectedToNetwork: ConnectivityObserver.Status,
) {
    var howManyTimesClicked by remember {
        mutableStateOf(0)
    }
    Row {
        Text(text = text);
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = null,
            modifier = Modifier.clickable { deleteExerciseFromDatabase() })

        if (isConnectedToNetwork == ConnectivityObserver.Status.Available) {
            Icon(
                imageVector = Icons.Default.DeleteForever,
                //FIXME: wont work in lightmode
                tint = if(howManyTimesClicked==1) Color.Red else Color.White,
                contentDescription = null,
                modifier = Modifier.clickable {
                    howManyTimesClicked++
                    if(howManyTimesClicked < 2) return@clickable
                    deleteExerciseFromRemote()
                })
        }

    }
}