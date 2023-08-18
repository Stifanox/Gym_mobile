package com.example.gym.cycle_feature.ui.screens.training_editor_screen.view_models

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.gym.domain.repository.database.CyclesRepositoryDatabase
import com.example.gym.domain.repository.database.ExercisesRepositoryDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.*
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

    val listOfTrainings = mutableStateListOf<TrainingData>()

    fun setIdTraining(nameOfCycle: String?) {
        val name = nameOfCycle ?: ""
        idTraining = cyclesRepositoryDatabase.getIdFromCycleName(name)
    }

    fun addNewTraining() {
        listOfTrainings.add(
            TrainingData(
                idOfItem = listOfTrainings.size - 1,
                order = currentTrainingOrder,
                trainingDay = currentDayOfTraining
            )
        )
    }

    fun setTrainingReps(reps: String, id:Int) {
        val (index, trainingDay) = findTraining(id)
        listOfTrainings[index] = trainingDay.copy(reps = reps)
    }

    fun setTrainingSets(sets: String, id:Int){
        val (index, trainingDay) = findTraining(id)
        listOfTrainings[index] = trainingDay.copy(sets = sets)
    }

    fun setTrainingWeight(weight: Int, id:Int) {
        val (index, trainingDay) = findTraining(id)
        listOfTrainings[index] = trainingDay.copy(weight = weight)
    }

    fun setTrainingExercise(exercise: Int, id:Int) {
        val (index, trainingDay) = findTraining(id)
        listOfTrainings[index] = trainingDay.copy(exerciseId = exercise)
    }

    private fun findTraining(id: Int): Pair<Int, TrainingData> {
        val foundTrainingData = listOfTrainings.find { item -> item.idOfItem == id } as TrainingData
        val indexOfTraining = listOfTrainings.indexOf(foundTrainingData)
        return Pair(indexOfTraining, foundTrainingData)
    }
}