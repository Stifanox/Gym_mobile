package com.example.gym.exercise_feature.domain.use_cases

import com.example.gym.data.remote.model.response.ExerciseRemote
import com.example.gym.data.remote.model.response.ResponseRemote
import com.example.gym.domain.repository.remote.ExercisesRepository
import javax.inject.Inject

class FetchExercisesUseCase @Inject constructor(
    private val exercisesRepository: ExercisesRepository
) {

    suspend operator fun invoke(): ResponseRemote<List<ExerciseRemote>> {
        return exercisesRepository.getAllExercises()
    }
}