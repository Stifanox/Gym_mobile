package com.example.gym.data.database.repository

import com.example.gym.data.database.dao.CycleDao
import com.example.gym.data.database.model.TrainingCycleDatabase
import com.example.gym.data.database.model.TrainingDayDatabase
import com.example.gym.data.database.model.TrainingDayWithName
import com.example.gym.domain.repository.database.CyclesRepositoryDatabase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CyclesRepositoryDatabaseImpl @Inject constructor(
    private val cycleDao: CycleDao
):CyclesRepositoryDatabase {

    override fun getAllCycles(): Flow<List<TrainingCycleDatabase>> = cycleDao.getAllCycles()

    override fun getAllTrainingDaysByCycleId(id:Int):Flow<List<TrainingDayWithName>> = cycleDao.getAllTrainingDaysByCycleId(id)

    override fun addNewCycle(cycle:TrainingCycleDatabase) = cycleDao.addNewCycle(cycle)

    override fun addNewTrainingDayToCycle(trainingDayDatabase: TrainingDayDatabase) = cycleDao.addNewTrainingDayToCycle(trainingDayDatabase)

    override fun deleteCycle(cycle:TrainingCycleDatabase) = cycleDao.deleteCycle(cycle)

    override fun deleteTrainingDay(trainingDay: TrainingDayDatabase) = cycleDao.deleteTrainingDay(trainingDay)
}