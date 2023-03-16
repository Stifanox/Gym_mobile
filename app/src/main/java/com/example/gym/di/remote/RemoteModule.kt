package com.example.gym.di.remote

import com.example.gym.data.remote.repository.ExercisesRepositoryImpl
import com.example.gym.domain.repository.remote.ExercisesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RemoteModule {

    @Binds
    abstract fun bindExerciseRepository(
        exercisesRepositoryImpl: ExercisesRepositoryImpl
    ):ExercisesRepository
}