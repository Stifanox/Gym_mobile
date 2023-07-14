package com.example.gym.cycle_feature.ui.screens.cycle_add_screen.view_models

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.example.gym.R
import com.example.gym.cycle_feature.domain.use_cases.cycle_add_use_cases.CycleAddUseCases
import com.example.gym.data.database.model.TrainingCycleDatabase
import com.example.gym.domain.fetching_status.FetchingStatus
import com.example.gym.domain.token.TokenManagerSharedPreferences
import com.example.gym.domain.user_id.UserIdManager
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CycleAddScreenViewModel @Inject constructor(
    private val cycleAddUseCases: CycleAddUseCases,
    private val userIdManager: UserIdManager,
    @ApplicationContext private val context: Context
) : ViewModel() {


    private val workManager: WorkManager = WorkManager.getInstance(context)

    private var _cycleName = MutableStateFlow("")
    val cycleName = _cycleName.asStateFlow()

    private var _databaseSaveState: MutableStateFlow<FetchingStatus> =
        MutableStateFlow(FetchingStatus.InProgress)
    val databaseSaveState = _databaseSaveState.asStateFlow()

    private var _remoteSaveState = MutableStateFlow<FetchingStatus>(FetchingStatus.InProgress)
    val remoteSaveState = _remoteSaveState.asStateFlow()


    fun setCycleName(name: String) {
        _cycleName.update {
            name
        }
    }


    fun saveCycleToDatabase() {

        //TODO: maybe pass navigation function here so after the work is done make decision to make toast or navigate further
        val request = OneTimeWorkRequestBuilder<SaveToDatabaseWorker>()
            .setInputData(
                workDataOf(
                    //TODO: later get user id from server and pass it here or make call to server ( i think it's even better option)
                    SaveToDatabaseWorker.KEY_ID_OF_USER to 0,
                    SaveToDatabaseWorker.KEY_NAME_OF_CYCLE to _cycleName.value.lowercase()
                )
            ).build()

        workManager.enqueue(request)
}

    fun saveCycleToRemote() {
        viewModelScope.launch {
            try {
                val token = TokenManagerSharedPreferences.getTokenFromSharedPreferences(context)
                cycleAddUseCases.addCycleToRemote(token, _cycleName.value.lowercase())
            } catch (e: HttpException) {
                _remoteSaveState.update {
                    FetchingStatus.Error(context.getString(R.string.cycle_add_database_error))
                }
            } catch (e: IOException) {
                _remoteSaveState.update {
                    FetchingStatus.Error(context.getString(R.string.internet_error))
                }
            }
        }
    }

    fun saveToDatabaseAndRemote() {
        this.saveCycleToDatabase()
        this.saveCycleToRemote()
    }
}

fun createDatabaseItem(name: String, userId: Int?): TrainingCycleDatabase {
    return TrainingCycleDatabase(0, userId, name)
}