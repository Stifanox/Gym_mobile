package com.example.gym.data.remote.api

import com.example.gym.data.remote.model.response.ResponseRemote
import com.example.gym.data.remote.model.response.TrainingDayRemote
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TrainingDayApi {

    @GET("$PREFIX_TRAINING_DAY/{id}")
    suspend fun getTrainingDayById(@Path("id") id: Int): ResponseRemote<List<TrainingDayRemote>>

    @POST(PREFIX_TRAINING_DAY)
    suspend fun addNewTrainingDays(@Body trainingList: List<TrainingDayRemote>): ResponseRemote<String>

    @PUT(PREFIX_TRAINING_DAY)
    suspend fun updateTrainingDays(@Body trainingList: List<TrainingDayRemote>): ResponseRemote<String>

    @DELETE(PREFIX_TRAINING_DAY)
    suspend fun deleteTrainingDays(@Body trainingIds: List<Int>): ResponseRemote<String>
}