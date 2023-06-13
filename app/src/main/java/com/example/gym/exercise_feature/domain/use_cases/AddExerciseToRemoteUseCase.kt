package com.example.gym.exercise_feature.domain.use_cases

import com.example.gym.data.database.model.ExerciseDatabase
import com.example.gym.data.remote.model.request.ExerciseAddRemote
import com.example.gym.data.remote.model.response.ExerciseRemote
import com.example.gym.domain.repository.database.ExercisesRepositoryDatabase
import com.example.gym.domain.repository.remote.ExercisesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class AddExerciseToRemoteUseCase @Inject constructor(
    private val exercisesRepository: ExercisesRepository
) {

   suspend operator fun invoke(exercise:ExerciseAddRemote,token:String){
        exercisesRepository.addNewExercise(exercise,token)
    }
}