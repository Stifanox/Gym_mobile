package com.example.gym.di.remote

import com.example.gym.data.remote.repository.*
import com.example.gym.domain.repository.remote.*
import com.example.gym.domain.use_cases.login_screen.LoginUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
abstract class RemoteModule {

    @Binds
    abstract fun bindExerciseRepository(
        exercisesRepositoryImpl: ExercisesRepositoryImpl
    ):ExercisesRepository

    @Binds
    abstract fun bindCyclesRepository(
        cyclesRepositoryImpl: CycleRepositoryImpl
    ): CyclesRepository

    @Binds
    abstract fun bindHistoryRepository(
        historyRepositoryImpl: HistoryRepositoryImpl
    ): HistoryRepository

    @Binds
    abstract fun bindTrainingDayRepository(
        trainingDayRepositoryImpl: TrainingDayRepositoryImpl
    ): TrainingDayRepository

    @Binds
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

}