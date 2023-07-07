package com.example.gym.exercise_feature.ui.screens.exercise_list_screen.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gym.R
import com.example.gym.domain.common_functions.launchToast
import com.example.gym.domain.connection.ConnectivityObserver
import com.example.gym.domain.fetching_status.FetchingStatus
import com.example.gym.exercise_feature.ui.screens.exercise_list_screen.view_models.ExerciseListViewModel

data class FABActions(
    val text: String,
    val action: () -> Unit
)

@Composable
fun ExerciseListScreen(
    navigateToAddItemScreen:()->Unit,
    exerciseListViewModel: ExerciseListViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    //State to
    val state by exerciseListViewModel.exerciseState.collectAsState(initial = listOf())
    val networkState by exerciseListViewModel.networkState.collectAsState(initial = ConnectivityObserver.Status.Unavailable)

    //Handling all exceptions
    val databaseSaveState by exerciseListViewModel.databaseSaveState.collectAsState()
    val databaseDeleteState by exerciseListViewModel.databaseDeleteState.collectAsState()
    val remoteDeleteState by exerciseListViewModel.remoteDeleteState.collectAsState()

    //Dropdown menu for FAB
    var isDropdownMenuVisible by rememberSaveable {
        mutableStateOf(false)
    }

    //Launched effects to manage toast messages
    launchToast(context = context, dataToObserve = databaseDeleteState)
    launchToast(context = context, dataToObserve = databaseSaveState)
    launchToast(context = context, dataToObserve = remoteDeleteState)

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(state.sortedBy { item -> item.exerciseName }, key = {item -> item.id  }) { exercise ->
                ExerciseListItem(
                    text = exercise.exerciseName.replaceFirstChar { char -> char.uppercase() },
                    type = exercise.exerciseType,
                    deleteExerciseFromDatabase = {
                        exerciseListViewModel.deleteExerciseFromDatabase(
                            exercise
                        )
                    },
                    deleteExerciseFromRemote = {
                        exerciseListViewModel.deleteExerciseFromRemote(
                            exercise
                        )
                    },
                    isConnectedToNetwork = networkState
                )
            }
        }
        FloatingActionButton(
            onClick = { isDropdownMenuVisible = true },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(imageVector = Icons.Default.List, contentDescription = null)
        }
        //I guess offset works?
        DropdownMenu(
            offset = DpOffset(1000.dp, 0.dp),
            expanded = isDropdownMenuVisible,
            onDismissRequest = { isDropdownMenuVisible = false }) {
            createActionList(context,
                { isDropdownMenuVisible = false
                navigateToAddItemScreen()},
                {
                    isDropdownMenuVisible = false
                    exerciseListViewModel.fetchNewData()
                }).forEach { item ->
                DropdownMenuItem(onClick = { item.action() }) {
                    Text(text = item.text)
                }
            }
        }
    }
}

//FIXME: code it in such better way
fun createActionList(
    context: Context,
    actionOne: () -> Unit,
    actionTwo: () -> Unit
): List<FABActions> {


    return listOf(
        FABActions(context.getString(R.string.add_new_exercise), actionOne),
        FABActions(context.getString(R.string.fetch_exercises), actionTwo)
    )
}
