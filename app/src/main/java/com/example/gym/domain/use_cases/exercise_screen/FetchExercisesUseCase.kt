package com.example.gym.domain.use_cases.exercise_screen

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