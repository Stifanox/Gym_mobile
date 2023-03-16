package com.example.gym.data.remote.model.request

data class TrainingDayAddRemote(
    val trainingDay: Int,
    val exerciseId: Int,
    val weight: Int,
    val sets: Int,
    val reps: Int,
    val trainingCycleId: Int
)