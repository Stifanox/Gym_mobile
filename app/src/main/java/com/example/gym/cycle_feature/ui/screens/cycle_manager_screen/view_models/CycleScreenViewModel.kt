package com.example.gym.cycle_feature.ui.screens.cycle_manager_screen.view_models

import androidx.lifecycle.ViewModel
import com.example.gym.domain.fetching_status.FetchingStatus
import com.example.gym.domain.repository.database.CyclesRepositoryDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CycleScreenViewModel @Inject constructor(
    cyclesRepositoryDatabase: CyclesRepositoryDatabase,
) :ViewModel() {

    val cycleState = cyclesRepositoryDatabase.getAllCycles()



}