package com.example.gym.data.remote.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class TrainingDayRemote(
    val id:Int,
    @SerializedName("training_day") val trainingDay:Int,
    @SerializedName("exercise_id") val exerciseId:Int,
    val weight:Int,
    val reps:Int,
    @SerializedName("training_cycle_id") val trainingCycleId:Int,
    val sets:Int
)
