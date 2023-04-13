package com.example.gym.data.remote.repository

import com.example.gym.data.remote.api.ExercisesApi
import com.example.gym.data.remote.model.request.ExerciseAddRemote
import com.example.gym.data.remote.model.response.ExerciseRemote
import com.example.gym.data.remote.model.response.ResponseRemote
import com.example.gym.domain.repository.remote.ExercisesRepository
import javax.inject.Inject

class ExercisesRepositoryImpl @Inject constructor(
    private val exercisesApi: ExercisesApi
) : ExercisesRepository {
    override suspend fun getAllExercises(): ResponseRemote<List<ExerciseRemote>> =
        exercisesApi.getAllExercises()

    override suspend fun getExerciseById(id: Int) = exercisesApi.getExerciseById(id)

    override suspend fun addNewExercise(exercise: ExerciseAddRemote, token: String) =
        exercisesApi.addNewExercise(exercise, token)

    override suspend fun deleteExerciseById(id: Int, token: String): ResponseRemote<String> =
        exercisesApi.deleteExerciseById(id, token)
}