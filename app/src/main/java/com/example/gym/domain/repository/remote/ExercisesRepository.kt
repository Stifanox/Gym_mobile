package com.example.gym.domain.repository.remote

import com.example.gym.data.remote.model.request.ExerciseAddRemote
import com.example.gym.data.remote.model.response.ExerciseRemote
import com.example.gym.data.remote.model.response.ResponseRemote

interface ExercisesRepository {
    suspend fun getAllExercises(): ResponseRemote<List<ExerciseRemote>>

    suspend fun getExerciseById(id:Int): ResponseRemote<ExerciseRemote>

    suspend fun addNewExercise(exercise: ExerciseAddRemote, token:String): ResponseRemote<String>
}