package com.example.gym.domain.repository.database


import com.example.gym.data.database.model.TrainingHistoryDatabase
import com.example.gym.data.database.model.TrainingHistoryWithName
import kotlinx.coroutines.flow.Flow

interface HistoriesRepositoryDatabase {
    fun addTrainingToHistory(history: TrainingHistoryDatabase)

    fun getAllHistory(): Flow<List<TrainingHistoryWithName>>

    fun getAllCycleHistoryById(id: Int): Flow<List<TrainingHistoryWithName>>
}