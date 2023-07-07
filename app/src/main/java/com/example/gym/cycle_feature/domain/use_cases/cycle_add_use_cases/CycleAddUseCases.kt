package com.example.gym.cycle_feature.domain.use_cases.cycle_add_use_cases

import javax.inject.Inject

data class CycleAddUseCases @Inject constructor(
    val addCycleToDatabase: AddCycleToDatabase
)