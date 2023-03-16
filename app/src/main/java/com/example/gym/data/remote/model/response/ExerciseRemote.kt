package com.example.gym.data.remote.model.response


import com.google.gson.annotations.SerializedName

data class ExerciseRemote(
    val id:Int,
    @SerializedName("exercise_name") val exerciseName:String,
    @SerializedName("exercise_type") val exerciseType:Int
)
