package com.example.gym.domain.use_cases.exercise_screen

import android.app.Application
import com.example.gym.data.remote.model.response.ResponseRemote
import com.example.gym.domain.repository.remote.ExercisesRepository
import com.example.gym.domain.token.TokenManagerSharedPreferences
import javax.inject.Inject

class DeleteExerciseFromRemoteUseCase @Inject constructor(
    private val exercisesRepository: ExercisesRepository,
    private val application: Application
) {

    suspend operator fun invoke(id:Int):ResponseRemote<String>{
        return exercisesRepository.deleteExerciseById(
            id,
            TokenManagerSharedPreferences.getTokenFromSharedPreferences(application)
        )
    }
}