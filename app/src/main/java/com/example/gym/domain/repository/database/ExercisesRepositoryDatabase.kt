package com.example.gym.domain.repository.database


import com.example.gym.data.database.model.ExerciseDatabase
import kotlinx.coroutines.flow.Flow

interface ExercisesRepositoryDatabase {
    fun getAllExercises(): Flow<List<ExerciseDatabase>>

    suspend fun addNewExercise(exercise: ExerciseDatabase)

    suspend fun addNewExerciseList(exercises:List<ExerciseDatabase>)

    suspend fun deleteExercise(exercise: ExerciseDatabase)

    suspend fun removeDuplicates()
}