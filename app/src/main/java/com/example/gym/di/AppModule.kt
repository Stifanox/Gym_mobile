package com.example.gym.di

import android.app.Application
import androidx.room.Room
import com.example.gym.data.database.GymDatabase
import com.example.gym.data.database.dao.CycleDao
import com.example.gym.data.database.dao.ExerciseDao
import com.example.gym.data.database.dao.HistoryDao
import com.example.gym.data.remote.RetrofitConfiguration
import com.example.gym.data.remote.api.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(
        application: Application
    ): GymDatabase {
        return Room.databaseBuilder(application, GymDatabase::class.java, "gym_database").build()
    }

    @Provides
    @Singleton
    fun provideCycleDao(database: GymDatabase): CycleDao {
        return database.cycleDao()
    }

    @Provides
    @Singleton
    fun provideExerciseDao(database: GymDatabase): ExerciseDao {
        return database.exerciseDao()
    }

    @Singleton
    @Provides
    fun provideHistoryDao(database: GymDatabase): HistoryDao {
        return database.historyDao()
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(RetrofitConfiguration.BASE_URL)
            .addConverterFactory(RetrofitConfiguration.CONVERTER_FACTORY)
            .build()
    }

    @Provides
    @Singleton
    fun provideExerciseApi(retrofit: Retrofit): ExercisesApi {
        return retrofit.create(ExercisesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCyclesApi(retrofit: Retrofit): CyclesApi {
        return retrofit.create(CyclesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHistoryApi(retrofit: Retrofit): HistoryApi {
        return retrofit.create(HistoryApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTrainingDayApi(retrofit: Retrofit): TrainingDayApi {
        return retrofit.create(TrainingDayApi::class.java)
    }

    @Provides
    @Singleton
    fun providesUserApi(retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }
}