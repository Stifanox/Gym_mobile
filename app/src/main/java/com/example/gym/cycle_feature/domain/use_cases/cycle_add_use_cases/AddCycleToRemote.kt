package com.example.gym.cycle_feature.domain.use_cases.cycle_add_use_cases

import com.example.gym.data.remote.model.request.CycleAddRemote
import com.example.gym.domain.repository.remote.CyclesRepository
import javax.inject.Inject

class AddCycleToRemote @Inject constructor(
    private val cyclesRepository: CyclesRepository
) {

    suspend operator fun invoke(token:String, name:String){
        cyclesRepository.addNewCycle(token, CycleAddRemote(name))
    }
}