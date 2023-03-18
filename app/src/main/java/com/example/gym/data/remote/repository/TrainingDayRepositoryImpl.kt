package com.example.gym.data.remote.repository

import com.example.gym.data.remote.api.TrainingDayApi
import com.example.gym.data.remote.model.request.TrainingDayAddRemote
import com.example.gym.data.remote.model.request.TrainingDayRequestRemote
import com.example.gym.data.remote.model.response.ResponseRemote
import com.example.gym.data.remote.model.response.TrainingDayRemote
import com.example.gym.domain.repository.remote.TrainingDayRepository
import javax.inject.Inject

class TrainingDayRepositoryImpl @Inject constructor(
    private val trainingDayApi: TrainingDayApi
) : TrainingDayRepository {
    override suspend fun getTrainingDayById(id: Int): ResponseRemote<List<TrainingDayRemote>> =
        trainingDayApi.getTrainingDayById(id)

    override suspend fun addNewTrainingDays(trainingList: TrainingDayRequestRemote<TrainingDayAddRemote>): ResponseRemote<String> =
        trainingDayApi.addNewTrainingDays(trainingList)

    override suspend fun updateTrainingDays(trainingList: TrainingDayRequestRemote<TrainingDayAddRemote>): ResponseRemote<String> =
        trainingDayApi.updateTrainingDays(trainingList)


    override suspend fun deleteTrainingDays(trainingIds: TrainingDayRequestRemote<Int>): ResponseRemote<String> =
        trainingDayApi.deleteTrainingDays(trainingIds)

}