package com.example.gym.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class TrainingCycleRemote(
    val id:Int,
    @SerializedName("user_id") val userId:Int,
    @SerializedName("cycle_name") val cycleName:String
)
