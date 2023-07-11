package com.example.gym.domain.repository.database


import com.example.gym.data.database.model.TrainingCycleDatabase
import com.example.gym.data.database.model.TrainingDayDatabase
import com.example.gym.data.database.model.TrainingDayWithName
import com.example.gym.data.remote.model.response.ResponseRemote
import kotlinx.coroutines.flow.Flow

interface CyclesRepositoryDatabase {

    fun getAllCycles(): Flow<List<TrainingCycleDatabase>>

    fun getAllTrainingDaysByCycleId(id: Int): Flow<List<TrainingDayWithName>>

    fun addNewCycle(cycle: TrainingCycleDatabase)

    fun addNewTrainingDayToCycle(trainingDayDatabase: TrainingDayDatabase)

    fun deleteCycle(cycle: TrainingCycleDatabase)

    fun deleteTrainingDay(trainingDay: TrainingDayDatabase)

    fun addCycleList(cycles: List<TrainingCycleDatabase>)

}