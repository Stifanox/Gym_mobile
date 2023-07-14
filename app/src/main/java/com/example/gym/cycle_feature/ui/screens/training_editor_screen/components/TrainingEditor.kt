package com.example.gym.cycle_feature.ui.screens.training_editor_screen.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gym.cycle_feature.ui.screens.training_editor_screen.view_models.TrainingEditorViewModel

@Composable
fun TrainingEditor(
    nameOfCycle: String?,
    trainingEditorViewModel: TrainingEditorViewModel = hiltViewModel()
) {

    val idOfTraining by trainingEditorViewModel.idTraining.collectAsState(initial = 2)
    LaunchedEffect(key1 = null) {
        trainingEditorViewModel.setIdTraining(nameOfCycle)
    }

    Text(idOfTraining.toString())
}