package com.example.gym.exercise_feature.domain.use_cases

import com.example.gym.data.database.model.ExerciseDatabase
import com.example.gym.domain.repository.database.ExercisesRepositoryDatabase
import javax.inject.Inject

class SaveExercisesListUseCase @Inject constructor(
    private val exercisesRepositoryDatabase: ExercisesRepositoryDatabase
) {

    suspend operator fun invoke(exercises:List<ExerciseDatabase>){
        exercisesRepositoryDatabase.addNewExerciseList(exercises)
    }
}