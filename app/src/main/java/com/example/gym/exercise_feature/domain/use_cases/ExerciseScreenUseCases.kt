package com.example.gym.exercise_feature.domain.use_cases

import javax.inject.Inject

data class ExerciseScreenUseCases @Inject constructor (
    val fetchExercisesUseCase: FetchExercisesUseCase,
    val saveExercisesListUseCase: SaveExercisesListUseCase,
    val deleteExerciseFromDatabaseUseCase: DeleteExerciseFromDatabaseUseCase,
    val deleteExerciseFromRemoteUseCase: DeleteExerciseFromRemoteUseCase,
    val addExerciseToDatabaseUseCase: AddExerciseToDatabaseUseCase,
    val addExerciseToRemoteUseCase: AddExerciseToRemoteUseCase,
    val removeDuplicatesUseCase:RemoveDuplicatesUseCase
)