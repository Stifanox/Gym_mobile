package com.example.gym.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "training_day")
data class TrainingDayDatabase(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "training_day") val trainingDay:Int,
    @ColumnInfo(name = "exercise_id") val exerciseId:Int,
    val weight:Int,
    val reps:Int,
    //This column was added later and auto-migration can't handle it in proper way so it requires default value
    @ColumnInfo(defaultValue = "0") val order:Int,
    @ColumnInfo(name = "training_cycle_id") val trainingCycleId:Int,
    val sets:Int
)
