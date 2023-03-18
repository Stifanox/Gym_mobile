package com.example.gym.data.remote.repository

import com.example.gym.data.remote.api.CyclesApi
import com.example.gym.data.remote.model.request.CycleAddRemote
import com.example.gym.data.remote.model.request.CycleEditRemote
import com.example.gym.data.remote.model.response.ResponseRemote
import com.example.gym.data.remote.model.response.TrainingCycleRemote
import com.example.gym.domain.repository.remote.CyclesRepository
import javax.inject.Inject

class CycleRepositoryImpl @Inject constructor(
    private val cyclesApi: CyclesApi
) : CyclesRepository {
    override suspend fun getCyclesByUserId(token: String): ResponseRemote<List<TrainingCycleRemote>> =
        cyclesApi.getCyclesByUserId(token)

    override suspend fun getCyclesById(
        id: Int,
        token: String
    ): ResponseRemote<List<TrainingCycleRemote>> = cyclesApi.getCyclesById(id, token)

    override suspend fun addNewCycle(
        token: String,
        cycleName: CycleAddRemote
    ): ResponseRemote<String> = cyclesApi.addNewCycle(token, cycleName)

    override suspend fun editCycle(token: String, cycle: CycleEditRemote): ResponseRemote<String> =
        cyclesApi.editCycle(token, cycle)
}