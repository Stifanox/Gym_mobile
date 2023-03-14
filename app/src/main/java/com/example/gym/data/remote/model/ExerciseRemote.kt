package com.example.gym.data.remote.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class ExerciseRemote(
    val id:Int,
    @SerializedName("exercise_name") val exerciseName:String,
    @SerializedName("exercise_type") val exerciseType:Int
)
