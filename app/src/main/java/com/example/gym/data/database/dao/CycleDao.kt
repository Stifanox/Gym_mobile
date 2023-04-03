package com.example.gym.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.gym.data.database.model.TrainingCycleDatabase
import com.example.gym.data.database.model.TrainingDayDatabase
import com.example.gym.data.database.model.TrainingDayWithName
import kotlinx.coroutines.flow.Flow

@Dao
interface CycleDao {

    @Query("SELECT *  FROM training_cycle")
    fun getAllCycles():Flow<List<TrainingCycleDatabase>>

    @Query("SELECT * FROM training_day WHERE id = :id")
    fun getAllTrainingDaysByCycleId(id:Int):Flow<List<TrainingDayWithName>>

    @Insert
    fun addNewCycle(cycle:TrainingCycleDatabase)

    @Insert
    fun addNewTrainingDayToCycle(trainingDayDatabase: TrainingDayDatabase)

    @Delete
    fun deleteCycle(cycle:TrainingCycleDatabase)

    @Delete
    fun deleteTrainingDay(trainingDay:TrainingDayDatabase)
}