package com.example.gym.data.remote.model.response

import com.google.gson.annotations.SerializedName
import java.util.*

data class TrainingHistoryRemote(
    val id:Int,
    @SerializedName("user_id") val userId:Int,
    @SerializedName("exercise_id") val exerciseId:Int,
    //TODO: później sprawdzić jaki typ danych jest tu zwracany
    @SerializedName("training_date") val trainingDate:Date,
    @SerializedName("training_cycle_id") val trainingCycleId:Int,
    val reps:Int,
    val weight:Int,
    val sets:Int,
)
