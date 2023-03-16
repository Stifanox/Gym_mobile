package com.example.gym.domain.repository.remote

import com.example.gym.data.remote.model.response.ResponseRemote
import com.example.gym.data.remote.model.response.TrainingDayRemote

interface TrainingDayRepository {
    suspend fun getTrainingDayById(id: Int): ResponseRemote<List<TrainingDayRemote>>

    suspend fun addNewTrainingDays(trainingList: List<TrainingDayRemote>): ResponseRemote<String>

    suspend fun updateTrainingDays(trainingList: List<TrainingDayRemote>): ResponseRemote<String>

    suspend fun deleteTrainingDays(trainingIds: List<Int>): ResponseRemote<String>
}