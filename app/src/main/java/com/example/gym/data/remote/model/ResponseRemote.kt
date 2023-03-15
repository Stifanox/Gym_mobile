package com.example.gym.data.remote.model

data class ResponseRemote<T>(
    val status:String,
    val data:T
)
