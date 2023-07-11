package com.example.gym.cycle_feature.ui.screens.cycle_manager_screen.view_models

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gym.R
import com.example.gym.data.database.model.TrainingCycleDatabase
import com.example.gym.data.remote.model.response.toDatabase
import com.example.gym.domain.connection.ConnectivityObserver
import com.example.gym.domain.fetching_status.FetchingStatus
import com.example.gym.domain.repository.database.CyclesRepositoryDatabase
import com.example.gym.domain.repository.remote.CyclesRepository
import com.example.gym.domain.token.TokenManagerSharedPreferences
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
class CycleScreenViewModel @Inject constructor(
    private val cyclesRepositoryDatabase: CyclesRepositoryDatabase,
    private val cyclesRepository: CyclesRepository,
    connectivityObserver: ConnectivityObserver,
    @ApplicationContext private val context: Context
) : ViewModel() {

    val cycleState = cyclesRepositoryDatabase.getAllCycles()
    val networkState = connectivityObserver.observe()

    private var _fetchCycleRemoteState = MutableStateFlow<FetchingStatus>(FetchingStatus.InProgress)
    val fetchCycleRemoteState = _fetchCycleRemoteState.asStateFlow()

    private var _saveToDatabaseState = MutableStateFlow<FetchingStatus>(FetchingStatus.InProgress)
    val saveToDatabaseState = _saveToDatabaseState.asStateFlow()
    fun fetchCyclesFromRemote() {
        viewModelScope.launch {
            try {
                var result = cyclesRepository.getCyclesByUserId(
                    TokenManagerSharedPreferences.getTokenFromSharedPreferences(context)
                )
                this@CycleScreenViewModel.saveCyclesToDatabase(result.data.map { it.toDatabase() })
            } catch (e: HttpException) {
                _fetchCycleRemoteState.update {
                    FetchingStatus.Error(context.getString(R.string.fetch_cycle_remote_error))
                }
            } catch (e: IOException) {
                _fetchCycleRemoteState.update {
                    FetchingStatus.Error(context.getString(R.string.internet_error))
                }
            }
        }
    }

    private fun saveCyclesToDatabase(cycles: List<TrainingCycleDatabase>) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                cyclesRepositoryDatabase.addCycleList(cycles)
            } catch (e: IOException) {
                _saveToDatabaseState.update {
                    FetchingStatus.Error(context.getString(R.string.database_save_error))
                }
            }
        }
    }

    fun removeFromDatabase(cycle: TrainingCycleDatabase) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                cyclesRepositoryDatabase.deleteCycle(cycle)
            } catch (e: IOException) {

            }
        }
    }

    fun removeFromRemoteAndDatabase(cycle: TrainingCycleDatabase) {
        viewModelScope.launch {
            try {
                cyclesRepository.deleteCycle(
                    TokenManagerSharedPreferences.getTokenFromSharedPreferences(
                        context
                    ), cycle.cycleName
                )
                removeFromDatabase(cycle)
            } catch (e:HttpException){
                Log.d("Not logged"," XD")
            } catch (e:IOException){
                Log.d("IO","IO")
            }

        }
    }
}