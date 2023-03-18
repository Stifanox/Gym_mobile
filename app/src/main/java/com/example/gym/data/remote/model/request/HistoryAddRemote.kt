package com.example.gym.data.remote.model.request

import com.example.gym.data.remote.model.response.TrainingDayRemote

data class HistoryAddRemote(
    val history:List<TrainingDayRemote>
)
