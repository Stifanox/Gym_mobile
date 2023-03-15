package com.example.gym.di.remote

import com.example.gym.data.remote.repository.ExerciseRepositoryImpl
import com.example.gym.domain.repository.remote.ExerciseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RemoteModule {

    @Binds
    abstract fun bindExerciseRepository(
        exerciseRepositoryImpl: ExerciseRepositoryImpl
    ):ExerciseRepository
}