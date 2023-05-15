package com.example.gym.domain.fetching_status


sealed interface FetchingStatus {
    data class Error(var error: String):FetchingStatus
    object Success:FetchingStatus
    object InProgress:FetchingStatus
}