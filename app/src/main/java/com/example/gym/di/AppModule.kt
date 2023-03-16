package com.example.gym.di

import com.example.gym.data.remote.api.ExercisesApi
import com.example.gym.data.remote.RetrofitConfiguration
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

//    @Provides
//    @Singleton
//    fun provideRoomDatabase(){
//    }

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit{
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
}