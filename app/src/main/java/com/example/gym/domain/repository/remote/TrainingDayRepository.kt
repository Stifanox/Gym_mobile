package com.example.gym.domain.repository.remote

import com.example.gym.data.remote.model.request.TrainingDayAddRemote
import com.example.gym.data.remote.model.request.TrainingDayRequestRemote
import com.example.gym.data.remote.model.response.ResponseRemote
import com.example.gym.data.remote.model.response.TrainingDayRemote

interface TrainingDayRepository {
    suspend fun getTrainingDayById(id: Int): ResponseRemote<List<TrainingDayRemote>>

    suspend fun addNewTrainingDays(trainingList: TrainingDayRequestRemote<TrainingDayAddRemote>): ResponseRemote<String>

    suspend fun updateTrainingDays(trainingList: TrainingDayRequestRemote<TrainingDayAddRemote>): ResponseRemote<String>

    suspend fun deleteTrainingDays(trainingIds: TrainingDayRequestRemote<Int>): ResponseRemote<String>
}