package com.example.gym.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "exercise", indices = [Index(value = ["id_remote"], unique = true)])
data class ExerciseDatabase(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "id_remote") val id_remote:Int?,
    @ColumnInfo(name = "exercise_name") val exerciseName:String,
    @ColumnInfo(name = "exercise_type") val exerciseType:Int
)
