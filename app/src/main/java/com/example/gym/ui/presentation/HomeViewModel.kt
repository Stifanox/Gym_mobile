package com.example.gym.ui.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gym.data.remote.model.ExerciseRemote
import com.example.gym.domain.repository.remote.ExerciseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val exerciseRepository: ExerciseRepository
) : ViewModel() {
    private var _listOfExercises = MutableStateFlow(listOf<ExerciseRemote>())
    val listOfExercises = _listOfExercises.asStateFlow()

     var error by mutableStateOf("Nie ma błędu")
        private set

    fun getAllExercises() {
        viewModelScope.launch {
            try {
                val list = exerciseRepository.getAllExercises()
                _listOfExercises.value = list.data
            } catch (e:IOException){
                error = "${e.message}"

            }catch (e:HttpException){
                error = "${e.message}"
            }
        }
    }
}