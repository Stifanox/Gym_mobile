package com.example.gym.data.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gym.data.database.dao.CycleDao
import com.example.gym.data.database.dao.ExerciseDao
import com.example.gym.data.database.dao.HistoryDao
import com.example.gym.data.database.model.ExerciseDatabase
import com.example.gym.data.database.model.TrainingCycleDatabase
import com.example.gym.data.database.model.TrainingDayDatabase
import com.example.gym.data.database.model.TrainingHistoryDatabase

//@Database(
//    entities = [ExerciseDatabase::class, TrainingCycleDatabase::class, TrainingDayDatabase::class, TrainingHistoryDatabase::class],
//    version = 1,
//    exportSchema = true
//)

//@Database(
//    entities = [ExerciseDatabase::class, TrainingCycleDatabase::class, TrainingDayDatabase::class, TrainingHistoryDatabase::class],
//    version = 2,
//    autoMigrations = [
//        AutoMigration(1,2)
//    ],
//     exportSchema = true
//)

//@Database(
//    entities = [ExerciseDatabase::class, TrainingCycleDatabase::class, TrainingDayDatabase::class, TrainingHistoryDatabase::class],
//    version = 3,
//    autoMigrations = [
//        AutoMigration(2,3)
//    ],
//    exportSchema = true
//)

//@Database(
//    entities = [ExerciseDatabase::class, TrainingCycleDatabase::class, TrainingDayDatabase::class, TrainingHistoryDatabase::class],
//    version = 4,
//    autoMigrations = [
//        AutoMigration(3,4)
//    ],
//    exportSchema = true
//)

//@Database(
//    entities = [ExerciseDatabase::class, TrainingCycleDatabase::class, TrainingDayDatabase::class, TrainingHistoryDatabase::class],
//    version = 5,
//    autoMigrations = [
//        AutoMigration(4,5)
//    ],
//    exportSchema = true
//)

//@Database(
//    entities = [ExerciseDatabase::class, TrainingCycleDatabase::class, TrainingDayDatabase::class, TrainingHistoryDatabase::class],
//    version = 6,
//    autoMigrations = [
//        AutoMigration(5,6)
//    ],
//    exportSchema = true
//)

@Database(
    entities = [ExerciseDatabase::class, TrainingCycleDatabase::class, TrainingDayDatabase::class, TrainingHistoryDatabase::class],
    version = 7,
    autoMigrations = [
        AutoMigration(6,7)
    ],
    exportSchema = true
)
abstract class GymDatabase:RoomDatabase() {
    abstract fun cycleDao():CycleDao
    abstract fun exerciseDao():ExerciseDao
    abstract fun historyDao():HistoryDao
}
