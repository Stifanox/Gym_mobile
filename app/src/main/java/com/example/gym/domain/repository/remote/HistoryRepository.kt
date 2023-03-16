package com.example.gym.domain.repository.remote

import com.example.gym.data.remote.model.response.ResponseRemote
import com.example.gym.data.remote.model.response.TrainingHistoryRemote

interface HistoryRepository {
    suspend fun getUserHistory(token: String): ResponseRemote<List<TrainingHistoryRemote>>

    suspend fun addNewHistory(
        historyList: List<TrainingHistoryRemote>,
        token: String
    ): ResponseRemote<String>

    suspend fun deleteHistory(id:Int):ResponseRemote<String>
}