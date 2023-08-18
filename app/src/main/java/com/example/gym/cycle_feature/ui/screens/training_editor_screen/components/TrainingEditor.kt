package com.example.gym.cycle_feature.ui.screens.training_editor_screen.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gym.cycle_feature.ui.screens.training_editor_screen.view_models.TrainingEditorViewModel

@Composable
fun TrainingEditor(
    nameOfCycle: String?,
    trainingEditorViewModel: TrainingEditorViewModel = hiltViewModel()
) {

    val idOfTraining by trainingEditorViewModel.idTraining.collectAsState(initial = -1)
    val exerciseList by trainingEditorViewModel.exerciseList.collectAsState(initial = emptyList())
    val listOfTrainings = trainingEditorViewModel.listOfTrainings


    LaunchedEffect(key1 = null) {
        trainingEditorViewModel.setIdTraining(nameOfCycle)
    }

    LazyColumn {

        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            trainingEditorViewModel.addNewTraining()
                        }
                )
            }
        }

        items(listOfTrainings, key = { item -> item.idOfItem }) {
            ExerciseItemEditor(
                exerciseList = exerciseList,
                trainingData = it,
                setReps = trainingEditorViewModel::setTrainingReps,
                setSets = trainingEditorViewModel::setTrainingSets,
                setExercise = trainingEditorViewModel::setTrainingExercise,
                setWeight = trainingEditorViewModel::setTrainingWeight
            )
        }

    }


}