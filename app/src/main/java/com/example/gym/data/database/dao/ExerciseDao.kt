package com.example.gym.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.gym.data.database.model.ExerciseDatabase
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercise")
    fun getAllExercises():Flow<List<ExerciseDatabase>>


}