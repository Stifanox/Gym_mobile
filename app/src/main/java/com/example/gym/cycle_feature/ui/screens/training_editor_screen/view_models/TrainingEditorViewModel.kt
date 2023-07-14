package com.example.gym.cycle_feature.ui.screens.training_editor_screen.view_models

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.WorkManager
import com.example.gym.data.database.model.TrainingDayDatabase
import com.example.gym.data.database.model.TrainingDayWithName
import com.example.gym.domain.repository.database.CyclesRepositoryDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrainingEditorViewModel @Inject constructor(
    private val cyclesRepositoryDatabase: CyclesRepositoryDatabase,
    @ApplicationContext private val context:Context
) :ViewModel() {

    private var _trainingDays = MutableStateFlow<List<TrainingDayWithName>>(emptyList())
    val trainingDays = _trainingDays.asStateFlow()

    //FIXME: there must be emit function, otherwise the setIdTraining won't update, don't touch it
    var idTraining :Flow<Int?> = flow { emit(0) }
        private set


    fun setIdTraining(nameOfCycle:String?){
        val name = nameOfCycle ?: ""
        idTraining = cyclesRepositoryDatabase.getIdFromCycleName(name)

    }
}