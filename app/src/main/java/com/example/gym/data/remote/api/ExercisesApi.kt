package com.example.gym.data.remote.api

import com.example.gym.data.remote.model.request.ExerciseAddRemote
import com.example.gym.data.remote.model.response.ExerciseRemote
import com.example.gym.data.remote.model.response.ResponseRemote
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ExercisesApi {

    @GET(PREFIX_EXERCISES)
    suspend fun getAllExercises(): ResponseRemote<List<ExerciseRemote>>

    @GET("$PREFIX_EXERCISES/{id}")
    suspend fun getExerciseById(@Path("id") id: Int): ResponseRemote<ExerciseRemote>

    @POST(PREFIX_EXERCISES)
    suspend fun addNewExercise(
        @Body exercise: ExerciseAddRemote,
        @Header("Cookie") token: String
    ): ResponseRemote<String>
}