package com.example.gym.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.gym.data.database.model.TrainingHistoryDatabase
import com.example.gym.data.database.model.TrainingHistoryWithName
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

    @Insert
    fun addTrainingToHistory(history: TrainingHistoryDatabase)

    @Query("SELECT * FROM training_history")
    fun getAllHistory(): Flow<List<TrainingHistoryWithName>>

    @Query("SELECT * FROM training_history WHERE training_cycle_id = :id")
    fun getAllCycleHistoryById(id: Int): Flow<List<TrainingHistoryWithName>>
}