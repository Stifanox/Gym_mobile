package com.example.gym.data.remote.model.response

data class ResponseRemote<T>(
    val status:String,
    val data:T
)
