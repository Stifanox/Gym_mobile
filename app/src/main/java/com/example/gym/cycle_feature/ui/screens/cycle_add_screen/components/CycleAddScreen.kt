package com.example.gym.cycle_feature.ui.screens.cycle_add_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gym.R
import com.example.gym.cycle_feature.ui.screens.cycle_add_screen.view_models.CycleAddScreenViewModel
import com.example.gym.domain.common_functions.launchToast


@Composable
fun CycleAddScreen(
    navigateToTrainingEditor: (String) -> Unit,
    cycleAddScreenViewModel: CycleAddScreenViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val cycleState by cycleAddScreenViewModel.cycleName.collectAsState()
    val databaseSaveState by cycleAddScreenViewModel.databaseSaveState.collectAsState()
    val remoteSaveState by cycleAddScreenViewModel.remoteSaveState.collectAsState()

    launchToast(context = context, dataToObserve = databaseSaveState)
    launchToast(context = context, dataToObserve = remoteSaveState)

    Column {
        TextField(value = cycleState, onValueChange = { cycleAddScreenViewModel.setCycleName(it) })
        Button(onClick = {
            cycleAddScreenViewModel.saveCycleToDatabase()
            navigateToTrainingEditor(cycleState.lowercase())
        }) {
            Text(text = stringResource(id = R.string.add_item_to_database))
        }
        Button(onClick = { cycleAddScreenViewModel.saveCycleToRemote() }) {
            Text(text = stringResource(id = R.string.add_item_to_remote))
        }
        Button(onClick = {
            cycleAddScreenViewModel.saveToDatabaseAndRemote()
            navigateToTrainingEditor(cycleState.lowercase())
        }) {
            Text(text = stringResource(id = R.string.add_item_to_remote_and_database))
        }
    }

}