package com.example.gym.data.database.dao

import androidx.room.*
import com.example.gym.data.database.model.ExerciseDatabase
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercise")
    fun getAllExercises():Flow<List<ExerciseDatabase>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addNewExercise(exercise:ExerciseDatabase)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addNewExerciseList(exercises:List<ExerciseDatabase>)

    @Delete
    fun deleteExercise(exercise: ExerciseDatabase)
}