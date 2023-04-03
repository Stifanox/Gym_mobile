package com.example.gym.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "training_history")
data class TrainingHistoryDatabase(
    @PrimaryKey val id:Int,
    @ColumnInfo(name = "exercise_id") val exerciseId:Int,
    @ColumnInfo(name = "training_date") val trainingDate: String,
    @ColumnInfo(name = "training_cycle_id") val trainingCycleId:Int,
    val reps:Int,
    val weight:Int,
    val sets:Int,
)
