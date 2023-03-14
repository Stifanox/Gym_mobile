package com.example.gym.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "training_history")
data class TrainingHistoryDatabase(
    @PrimaryKey val id:Int,
    @ColumnInfo(name = "exercise_id") val exerciseId:Int,
    //TODO: później sprawdzić jaki typ danych jest tu zwracany
    @ColumnInfo(name = "training_date") val trainingDate:Date,
    @ColumnInfo(name = "training_cycle_id") val trainingCycleId:Int,
    val reps:Int,
    val weight:Int,
    val sets:Int,
)
