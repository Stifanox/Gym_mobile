package com.example.gym.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "training_cycle")
data class TrainingCycleModel(
    @PrimaryKey val id:Int,
    @ColumnInfo(name = "user_id") val userId:Int,
    @ColumnInfo(name = "cycle_name") val cycleName:String
)
