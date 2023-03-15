package com.example.gym.data.remote.api

import com.example.gym.data.remote.model.ExerciseAddRemote
import com.example.gym.data.remote.model.ExerciseRemote
import com.example.gym.data.remote.model.ResponseRemote
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ExerciseApi {

    @GET("exercises")
    suspend fun getAllExercises():ResponseRemote<List<ExerciseRemote>>

    @GET("exercises/{id}")
    suspend fun getExerciseById(@Path("id") id:Int)

    @POST("exercises")
    suspend fun addNewExercise(@Body exercise: ExerciseAddRemote,@Header("Cookie") token:String)
}