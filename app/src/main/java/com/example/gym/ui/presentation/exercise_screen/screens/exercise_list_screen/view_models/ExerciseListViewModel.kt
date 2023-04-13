package com.example.gym.ui.presentation.exercise_screen.screens.exercise_list_screen.view_models

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gym.data.database.model.ExerciseDatabase
import com.example.gym.data.remote.model.StatusRemote
import com.example.gym.data.remote.model.response.ExerciseRemote
import com.example.gym.data.remote.model.response.toDatabase
import com.example.gym.domain.repository.database.ExercisesRepositoryDatabase
import com.example.gym.domain.use_cases.exercise_screen.ExerciseScreenUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class ExerciseListViewModel @Inject constructor(
    private val exercisesRepositoryDatabase: ExercisesRepositoryDatabase,
    private val exerciseScreenUseCases: ExerciseScreenUseCases
) : ViewModel() {

    val exerciseState = exercisesRepositoryDatabase.getAllExercises()


    fun fetchNewData() {
        try {
            viewModelScope.launch {
                val response = exerciseScreenUseCases.fetchExercisesUseCase()
                saveExercisesToDatabase(response.data)
            }
        } catch (e: IOException) {
            //TODO: implement
        } catch (e: HttpException) {
            //TODO: implement
        }
    }

    fun deleteExerciseFromDatabase(exercise:ExerciseDatabase) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                exerciseScreenUseCases.deleteExerciseFromDatabaseUseCase(exercise)
            } catch (e: IOException) {
                //TODO:implement
            }
        }
    }

    fun deleteExerciseFromRemote(exercise:ExerciseDatabase){
        viewModelScope.launch {
            try {
                val response = exerciseScreenUseCases.deleteExerciseFromRemoteUseCase(exercise.id)
                deleteExerciseFromDatabase(exercise)
                when(response.status){
                    StatusRemote.Success.status->{
                        //TODO:Implement
                    }
                    StatusRemote.Error.status->{
                        //TODO:implement
                    }
                }
            }
            catch (e:IOException){
                //TODO:implement
            }
            catch (e:HttpException){
                //TODO:implement
            }
        }
    }
    private fun saveExercisesToDatabase(exercises: List<ExerciseRemote>) {
        val exerciseMapped = exercises.map { it.toDatabase() }
        viewModelScope.launch(Dispatchers.IO) {
            exerciseScreenUseCases.saveExercisesListUseCase(exerciseMapped)
        }
    }
}