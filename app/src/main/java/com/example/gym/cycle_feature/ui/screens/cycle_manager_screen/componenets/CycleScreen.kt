package com.example.gym.cycle_feature.ui.screens.cycle_manager_screen.componenets

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gym.R
import com.example.gym.cycle_feature.domain.FABActions
import com.example.gym.cycle_feature.ui.screens.cycle_manager_screen.view_models.CycleScreenViewModel

@Composable
fun CycleScreen(
    navigateToAddScreen: () -> Unit,
    cycleScreenViewModel: CycleScreenViewModel = hiltViewModel()
) {

    var isDropdownMenuVisible by rememberSaveable {
        mutableStateOf(false)
    }

    val cycleState by cycleScreenViewModel.cycleState.collectAsState(initial = listOf())

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn {
            items(cycleState, key = { item -> item.id }) {
                CycleListItem(name = it.cycleName)
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
                {/* TODO: implement fetching from server*/}).forEach {
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