package com.example.gym.domain.use_cases.exercise_screen

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