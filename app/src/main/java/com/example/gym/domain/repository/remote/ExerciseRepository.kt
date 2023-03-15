package com.example.gym.domain.repository.remote

import com.example.gym.data.remote.model.ExerciseAddRemote
import com.example.gym.data.remote.model.ExerciseRemote
import com.example.gym.data.remote.model.ResponseRemote
import retrofit2.http.*

interface ExerciseRepository {
    suspend fun getAllExercises():ResponseRemote<List<ExerciseRemote>>

    suspend fun getExerciseById(id:Int)

    suspend fun addNewExercise(exercise: ExerciseAddRemote, token:String)
}