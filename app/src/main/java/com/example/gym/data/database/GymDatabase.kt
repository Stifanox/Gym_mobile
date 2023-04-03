package com.example.gym.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gym.data.database.dao.CycleDao
import com.example.gym.data.database.dao.ExerciseDao
import com.example.gym.data.database.dao.HistoryDao
import com.example.gym.data.database.model.ExerciseDatabase
import com.example.gym.data.database.model.TrainingCycleDatabase
import com.example.gym.data.database.model.TrainingDayDatabase
import com.example.gym.data.database.model.TrainingHistoryDatabase

@Database(
    entities = [ExerciseDatabase::class, TrainingCycleDatabase::class, TrainingDayDatabase::class, TrainingHistoryDatabase::class],
    version = 1
)
abstract class GymDatabase:RoomDatabase() {
    abstract fun cycleDao():CycleDao
    abstract fun exerciseDao():ExerciseDao
    abstract fun historyDao():HistoryDao
}