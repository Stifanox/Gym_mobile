package com.example.gym.ui.presentation.exercise_screen.screens.exercise_list_screen.view_models

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gym.R
import com.example.gym.data.database.model.ExerciseDatabase
import com.example.gym.data.remote.model.StatusRemote
import com.example.gym.data.remote.model.response.ExerciseRemote
import com.example.gym.data.remote.model.response.toDatabase
import com.example.gym.domain.connection.ConnectivityObserver
import com.example.gym.domain.fetching_status.FetchingStatus
import com.example.gym.domain.repository.database.ExercisesRepositoryDatabase
import com.example.gym.domain.use_cases.exercise_screen.ExerciseScreenUseCases
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
class ExerciseListViewModel @Inject constructor(
    exercisesRepositoryDatabase: ExercisesRepositoryDatabase,
    private val exerciseScreenUseCases: ExerciseScreenUseCases,
    connectivityObserver: ConnectivityObserver,
    @ApplicationContext private val context:Context
) : ViewModel() {

    val exerciseState = exercisesRepositoryDatabase.getAllExercises()
    val networkState = connectivityObserver.observe()

    private val _databaseSaveState:MutableStateFlow<FetchingStatus> = MutableStateFlow(FetchingStatus.InProgress)
    val databaseSaveState = _databaseSaveState.asStateFlow()

    private val _databaseDeleteState:MutableStateFlow<FetchingStatus> = MutableStateFlow(FetchingStatus.InProgress)
    val databaseDeleteState = _databaseDeleteState.asStateFlow()

    private val _remoteDeleteState:MutableStateFlow<FetchingStatus> = MutableStateFlow(FetchingStatus.InProgress)
    val remoteDeleteState = _remoteDeleteState.asStateFlow()

    fun fetchNewData() {
        try {
            viewModelScope.launch {
                val response = exerciseScreenUseCases.fetchExercisesUseCase()
                saveExercisesToDatabase(response.data)
            }
        } catch (e: IOException) {
            _databaseSaveState.update {
                 FetchingStatus.Error(context.getString(R.string.internet_error))
            }
        } catch (e: HttpException) {
            _databaseSaveState.update {
                FetchingStatus.Error("This shouldn't occur.")
            }
        }
    }

    fun deleteExerciseFromDatabase(exercise:ExerciseDatabase) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                exerciseScreenUseCases.deleteExerciseFromDatabaseUseCase(exercise)
                _databaseDeleteState.update {
                    FetchingStatus.Success
                }
            } catch (e: IOException) {
                _databaseDeleteState.update {
                    FetchingStatus.Error(context.getString(R.string.database_remove_problem))
                }
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
                        _remoteDeleteState.update {
                            FetchingStatus.Success
                        }
                    }
                    StatusRemote.Error.status->{
                        _remoteDeleteState.update {
                            FetchingStatus.Error(context.getString(R.string.remote_delete_error))
                        }
                    }
                }
            }
            catch (e:IOException){
                _remoteDeleteState.update {
                    FetchingStatus.Error(context.getString(R.string.internet_error))
                }
            }
            catch (e:HttpException){
                _remoteDeleteState.update {
                    FetchingStatus.Error(context.getString(R.string.exercise_delete_remote_error))
                }
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