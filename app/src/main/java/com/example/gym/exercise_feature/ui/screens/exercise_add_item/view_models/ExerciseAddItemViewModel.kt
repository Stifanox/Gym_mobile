package com.example.gym.exercise_feature.ui.screens.exercise_add_item.view_models

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gym.domain.token.TokenManagerSharedPreferences
import com.example.gym.exercise_feature.domain.use_cases.ExerciseScreenUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class ExerciseAddItemViewModel @Inject constructor(
    private val exerciseScreenUseCases: ExerciseScreenUseCases,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _exerciseState = MutableStateFlow(ExerciseItem())
    val exerciseState = _exerciseState.asStateFlow()


    fun setExerciseName(exerciseName: String) {
        _exerciseState.update { currentState ->
            currentState.copy(exerciseName = exerciseName)
        }
    }

    fun setExerciseType(exerciseType: Int) {
        _exerciseState.update { currentState ->
            currentState.copy(type = exerciseType)
        }
    }

    fun addItemToDatabase() {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                exerciseScreenUseCases.addExerciseToDatabaseUseCase(_exerciseState.value.toDatabase())
            } catch (e: IOException) {
                //TODO:implement
            } catch (e: HttpException) {
                //TODO:implement
            }
        }
    }

    fun addItemToRemote() {
        viewModelScope.launch {
            try {
                exerciseScreenUseCases.addExerciseToRemoteUseCase(
                    _exerciseState.value.toRemote(),
                    TokenManagerSharedPreferences.getTokenFromSharedPreferences(context)
                )
            } catch (e: IOException) {
                //TODO:implement
            } catch (e: HttpException) {
                //TODO:implement
            }
        }
    }

    fun addItemToRemoteAndDatabase() {
        this.addItemToDatabase()
        this.addItemToRemote()
    }

}