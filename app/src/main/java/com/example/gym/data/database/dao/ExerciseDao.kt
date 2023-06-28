package com.example.gym.data.database.dao

import androidx.room.*
import com.example.gym.data.database.model.ExerciseDatabase
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercise")
    fun getAllExercises():Flow<List<ExerciseDatabase>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewExercise(exercise:ExerciseDatabase)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewExerciseList(exercises:List<ExerciseDatabase>)

    @Delete
    fun deleteExercise(exercise: ExerciseDatabase)

    @Query("DELETE FROM exercise WHERE id NOT IN (SELECT * FROM exercise GROUP BY exercise_name WHERE)")
    fun removeDuplicates()
}