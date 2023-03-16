package com.example.gym.data.remote.api

import com.example.gym.data.remote.model.response.ResponseRemote
import com.example.gym.data.remote.model.response.TrainingHistoryRemote
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface HistoryApi {

    @GET(PREFIX_HISTORY)
    suspend fun getUserHistory(@Header("Cookie") token: String): ResponseRemote<List<TrainingHistoryRemote>>

    @POST(PREFIX_HISTORY)
    suspend fun addNewHistory(
        @Body historyList: List<TrainingHistoryRemote>,
        @Header("Cookie") token: String
    ): ResponseRemote<String>

    @DELETE("$PREFIX_HISTORY/{id}")
    suspend fun deleteHistory(@Path("id") id:Int):ResponseRemote<String>
}