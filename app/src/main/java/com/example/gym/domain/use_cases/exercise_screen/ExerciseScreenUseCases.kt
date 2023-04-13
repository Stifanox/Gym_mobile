package com.example.gym.domain.use_cases.exercise_screen

import javax.inject.Inject

data class ExerciseScreenUseCases @Inject constructor (
    val fetchExercisesUseCase: FetchExercisesUseCase,
    val saveExercisesListUseCase: SaveExercisesListUseCase,
    val deleteExerciseFromDatabaseUseCase: DeleteExerciseFromDatabaseUseCase,
    val deleteExerciseFromRemoteUseCase: DeleteExerciseFromRemoteUseCase
)