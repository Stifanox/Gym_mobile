package com.example.gym.exercise_feature.domain.use_cases

import android.util.Log
import com.example.gym.data.database.model.ExerciseDatabase
import com.example.gym.domain.repository.database.ExercisesRepositoryDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class AddExerciseToDatabaseUseCase @Inject constructor(
    private val exercisesRepositoryDatabase: ExercisesRepositoryDatabase,
) {

   suspend operator fun invoke(exercise:ExerciseDatabase){
        exercisesRepositoryDatabase.addNewExercise(exercise)
    }
}