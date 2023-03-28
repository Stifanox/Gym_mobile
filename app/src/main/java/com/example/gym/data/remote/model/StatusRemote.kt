package com.example.gym.data.remote.model

sealed class StatusRemote(val status:String){
    object Success:StatusRemote("Success")
    object Error:StatusRemote("Error")
}
