package com.example.gym.data.database.repository

import com.example.gym.data.database.dao.HistoryDao
import com.example.gym.data.database.model.TrainingHistoryDatabase
import com.example.gym.data.database.model.TrainingHistoryWithName
import com.example.gym.domain.repository.database.HistoriesRepositoryDatabase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HistoryRepositoryDatabaseImpl @Inject constructor(
    private val historyDao: HistoryDao
):HistoriesRepositoryDatabase {
    override fun addTrainingToHistory(history: TrainingHistoryDatabase) = historyDao.addTrainingToHistory(history)

    override fun getAllHistory(): Flow<List<TrainingHistoryWithName>> = historyDao.getAllHistory()

    override fun getAllCycleHistoryById(id: Int): Flow<List<TrainingHistoryWithName>> = historyDao.getAllCycleHistoryById(id)

}