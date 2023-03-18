package com.example.gym.data.remote.api

import com.example.gym.data.remote.model.request.TrainingDayAddRemote
import com.example.gym.data.remote.model.request.TrainingDayRequestRemote
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
    suspend fun addNewTrainingDays(@Body trainingList: TrainingDayRequestRemote<TrainingDayAddRemote>): ResponseRemote<String>

    @PUT(PREFIX_TRAINING_DAY)
    suspend fun updateTrainingDays(@Body trainingList: TrainingDayRequestRemote<TrainingDayAddRemote>): ResponseRemote<String>

    @DELETE(PREFIX_TRAINING_DAY)
    suspend fun deleteTrainingDays(@Body trainingIds: TrainingDayRequestRemote<Int>): ResponseRemote<String>
}