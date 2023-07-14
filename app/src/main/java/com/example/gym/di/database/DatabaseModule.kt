package com.example.gym.di.database

import com.example.gym.data.database.repository.CyclesRepositoryDatabaseImpl
import com.example.gym.data.database.repository.ExercisesRepositoryDatabaseImpl
import com.example.gym.data.database.repository.HistoryRepositoryDatabaseImpl
import com.example.gym.domain.repository.database.CyclesRepositoryDatabase
import com.example.gym.domain.repository.database.ExercisesRepositoryDatabase
import com.example.gym.domain.repository.database.HistoriesRepositoryDatabase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseModule {

    @Binds
    abstract fun bindExerciseRepository(
        exerciseRepositoryImpl: ExercisesRepositoryDatabaseImpl
    ): ExercisesRepositoryDatabase

    @Binds
    abstract fun bindCycleRepository(
        cycleRepositoryImpl: CyclesRepositoryDatabaseImpl
    ): CyclesRepositoryDatabase

    @Binds
    abstract fun bindHistoryRepository(
        historyRepositoryImpl: HistoryRepositoryDatabaseImpl
    ):HistoriesRepositoryDatabase
}