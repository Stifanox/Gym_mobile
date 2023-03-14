package com.example.gym.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise")
data class ExerciseDatabase(
    @PrimaryKey val id:Int,
    @ColumnInfo(name = "exercise_name") val exerciseName:String,
    @ColumnInfo(name = "exercise_type") val exerciseType:Int
)
