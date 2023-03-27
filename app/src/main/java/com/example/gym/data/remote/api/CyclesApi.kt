package com.example.gym.data.remote.api

import com.example.gym.data.remote.model.request.CycleAddRemote
import com.example.gym.data.remote.model.request.CycleEditRemote
import com.example.gym.data.remote.model.response.ResponseRemote
import com.example.gym.data.remote.model.response.TrainingCycleRemote
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface CyclesApi {

    @GET("$PREFIX_CYCLES/user")
    suspend fun getCyclesByUserId(@Header("Cookie") token: String): ResponseRemote<List<TrainingCycleRemote>>

    @GET("$PREFIX_CYCLES/{id}")
    suspend fun getCyclesById(
        @Path("id") id: Int,
        @Header("Cookie") token: String
    ): ResponseRemote<List<TrainingCycleRemote>>

    @POST(PREFIX_CYCLES)
    suspend fun addNewCycle(
        @Header("Cookie") token: String,
        @Body cycleName: CycleAddRemote
    ): ResponseRemote<String>

    @PUT(PREFIX_CYCLES)
    suspend fun editCycle(
        @Header("Cookie") token: String,
        @Body cycle: CycleEditRemote
    ): ResponseRemote<String>

}