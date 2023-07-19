package com.example.gym.cycle_feature.ui.screens.training_editor_screen.view_models

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gym.domain.repository.database.CyclesRepositoryDatabase
import com.example.gym.domain.repository.database.ExercisesRepositoryDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrainingEditorViewModel @Inject constructor(
    private val cyclesRepositoryDatabase: CyclesRepositoryDatabase,
    private val exercisesRepositoryDatabase: ExercisesRepositoryDatabase,
    @ApplicationContext private val context: Context
) : ViewModel() {


    //FIXME: there must be emit function, otherwise the setIdTraining won't update, don't touch it
    var idTraining: Flow<Int?> = flow { emit(0) }
        private set

    val exerciseList = exercisesRepositoryDatabase.getAllExercises()

    var currentDayOfTraining by mutableStateOf(1)
        private set

    var currentTrainingOrder by mutableStateOf(1)
        private set

    fun setIdTraining(nameOfCycle: String?) {
        val name = nameOfCycle ?: ""
        idTraining = cyclesRepositoryDatabase.getIdFromCycleName(name)
    }

    fun addNewTraining() {


    }

}