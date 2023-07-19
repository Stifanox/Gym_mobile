package com.example.gym.cycle_feature.ui.screens.cycle_manager_screen.componenets

import android.util.Log
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gym.R
import com.example.gym.cycle_feature.domain.FABActions
import com.example.gym.cycle_feature.ui.screens.cycle_manager_screen.view_models.CycleScreenViewModel
import com.example.gym.domain.common_functions.launchToast
import com.example.gym.domain.connection.ConnectivityObserver

@Composable
fun CycleScreen(
    navigateToAddScreen: () -> Unit,
    navigateToTrainingEditScreen:(String) -> Unit,
    cycleScreenViewModel: CycleScreenViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    var isDropdownMenuVisible by rememberSaveable {
        mutableStateOf(false)
    }
    val isConnectedToInternet by cycleScreenViewModel.networkState.collectAsState(
        ConnectivityObserver.Status.Unavailable
    )

    val cycleState by cycleScreenViewModel.cycleState.collectAsState(initial = listOf())
    val fetchingResult by cycleScreenViewModel.fetchCycleRemoteState.collectAsState()
    val saveResult by cycleScreenViewModel.saveToDatabaseState.collectAsState()

    launchToast(context = context, dataToObserve = fetchingResult)
    launchToast(context = context, dataToObserve = saveResult)

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn {
            items(cycleState, key = { item -> item.id }) {
                CycleListItem(
                    {cycleScreenViewModel.removeFromDatabase(it)},
                    {cycleScreenViewModel.removeFromRemoteAndDatabase(it)},
                    {navigateToTrainingEditScreen(it.cycleName)},
                    name = it.cycleName.replaceFirstChar { name -> name.uppercase() },
                    isConnectedToInternet
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

        DropdownMenu(
            offset = DpOffset(1000.dp, 0.dp),
            expanded = isDropdownMenuVisible,
            onDismissRequest = { isDropdownMenuVisible = false }) {
            createDropdownItemList(
                {
                    navigateToAddScreen()
                    isDropdownMenuVisible = false
                },
                {
                    cycleScreenViewModel.fetchCyclesFromRemote()
                    isDropdownMenuVisible = false
                }).forEach {
                DropdownMenuItem(onClick = { it.action() }) {
                    Text(text = stringResource(id = it.text))
                }
            }
        }
    }

}

fun createDropdownItemList(
    actionOne: () -> Unit,
    actionTwo: () -> Unit
): List<FABActions> {
    return listOf(
        FABActions(R.string.add_cycle, actionOne),
        FABActions(R.string.get_cycle_from_server, actionTwo)
    )
}