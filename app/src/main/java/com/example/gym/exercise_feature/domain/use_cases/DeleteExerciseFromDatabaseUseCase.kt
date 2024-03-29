package com.example.gym.exercise_feature.domain.use_cases

import com.example.gym.data.database.model.ExerciseDatabase
import com.example.gym.domain.repository.database.ExercisesRepositoryDatabase
import javax.inject.Inject

class DeleteExerciseFromDatabaseUseCase @Inject constructor(
    private val exercisesRepositoryDatabase: ExercisesRepositoryDatabase,
) {

    suspend operator fun invoke(exercise: ExerciseDatabase) {
        exercisesRepositoryDatabase.deleteExercise(exercise)
    }
}