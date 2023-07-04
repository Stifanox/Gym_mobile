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

    //TODO: fix this query ( when adding 2 same exercise_name solely to database without id_remote != NULL deletes both records)
    @Query("DELETE FROM exercise WHERE exercise_name IN (SELECT exercise_name FROM exercise GROUP BY exercise_name HAVING COUNT(exercise_name)>1 ) AND id_remote is NULL")
    fun removeDuplicates()
}

