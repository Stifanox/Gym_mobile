package com.example.gym.data.remote.repository

import com.example.gym.data.remote.api.HistoryApi
import com.example.gym.data.remote.model.request.HistoryAddRemote
import com.example.gym.data.remote.model.response.ResponseRemote
import com.example.gym.data.remote.model.response.TrainingHistoryRemote
import com.example.gym.domain.repository.remote.HistoryRepository
import javax.inject.Inject

class HistoryRepositoryImpl @Inject constructor(
    private val historyApi: HistoryApi
) : HistoryRepository {
    override suspend fun getUserHistory(token: String): ResponseRemote<List<TrainingHistoryRemote>> =
        historyApi.getUserHistory(token)

    override suspend fun addNewHistory(
        historyList: HistoryAddRemote,
        token: String
    ): ResponseRemote<String> = historyApi.addNewHistory(historyList, token)

    override suspend fun deleteHistory(id: Int): ResponseRemote<String> =
        historyApi.deleteHistory(id)
}