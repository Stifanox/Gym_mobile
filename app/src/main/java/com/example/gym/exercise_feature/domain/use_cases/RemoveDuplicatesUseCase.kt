package com.example.gym.exercise_feature.domain.use_cases

import com.example.gym.domain.repository.database.ExercisesRepositoryDatabase
import javax.inject.Inject


class RemoveDuplicatesUseCase @Inject constructor(
    private val exercisesRepositoryDatabase: ExercisesRepositoryDatabase
) {

    suspend operator fun invoke(){
        exercisesRepositoryDatabase.removeDuplicates()
    }
}