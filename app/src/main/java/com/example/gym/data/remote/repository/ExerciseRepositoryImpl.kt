package com.example.gym.data.remote.repository

import com.example.gym.data.remote.api.ExerciseApi
import com.example.gym.data.remote.model.ExerciseAddRemote
import com.example.gym.data.remote.model.ExerciseRemote
import com.example.gym.data.remote.model.ResponseRemote
import com.example.gym.domain.repository.remote.ExerciseRepository
import javax.inject.Inject

class ExerciseRepositoryImpl @Inject constructor(
    private val exerciseApi: ExerciseApi
) : ExerciseRepository {
    override suspend fun getAllExercises(): ResponseRemote<List<ExerciseRemote>> = exerciseApi.getAllExercises()

    override suspend fun getExerciseById(id: Int) = exerciseApi.getExerciseById(id)

    override suspend fun addNewExercise(exercise: ExerciseAddRemote, token: String) =
        exerciseApi.addNewExercise(exercise, token)
}