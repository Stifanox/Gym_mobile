package com.example.gym.domain.repository.remote

import com.example.gym.data.remote.model.request.CycleAddRemote
import com.example.gym.data.remote.model.request.CycleEditRemote
import com.example.gym.data.remote.model.response.ResponseRemote
import com.example.gym.data.remote.model.response.TrainingCycleRemote

interface CyclesRepository {
    suspend fun getCyclesByUserId(token: String): ResponseRemote<List<TrainingCycleRemote>>

    suspend fun getCyclesById(
        id: Int,
        token: String
    ): ResponseRemote<List<TrainingCycleRemote>>

    suspend fun addNewCycle(
        token: String,
        cycleName: CycleAddRemote
    ): ResponseRemote<String>

    suspend fun editCycle(
        token: String,
        cycle: CycleEditRemote
    ): ResponseRemote<String>
}