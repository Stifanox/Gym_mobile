package com.example.gym.data.database.repository

import com.example.gym.data.database.dao.ExerciseDao
import com.example.gym.data.database.model.ExerciseDatabase
import com.example.gym.domain.repository.database.ExercisesRepositoryDatabase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExercisesRepositoryDatabaseImpl @Inject constructor(
    private val exerciseDao: ExerciseDao
):ExercisesRepositoryDatabase {
    override fun getAllExercises(): Flow<List<ExerciseDatabase>> = exerciseDao.getAllExercises()

    override suspend fun addNewExercise(exercise: ExerciseDatabase) = exerciseDao.addNewExercise(exercise)

    override suspend fun addNewExerciseList(exercises:List<ExerciseDatabase>) = exerciseDao.addNewExerciseList(exercises)
    override suspend fun deleteExercise(exercise: ExerciseDatabase) = exerciseDao.deleteExercise(exercise)

    override suspend fun removeDuplicates() = exerciseDao.removeDuplicates()


}