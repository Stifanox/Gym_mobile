package com.example.gym.cycle_feature.domain.use_cases.cycle_add_use_cases

import com.example.gym.data.database.model.TrainingCycleDatabase
import com.example.gym.domain.repository.database.CyclesRepositoryDatabase
import javax.inject.Inject

class AddCycleToDatabase @Inject constructor(
    private val cyclesRepositoryDatabase: CyclesRepositoryDatabase
) {

    operator fun invoke(cycle:TrainingCycleDatabase){
        cyclesRepositoryDatabase.addNewCycle(cycle)
    }
}