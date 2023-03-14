package com.example.gym.data.database.model

import androidx.room.Embedded
import androidx.room.Relation

data class TrainingDayWithName(
    @Embedded val trainingDay:TrainingDayDatabase,
    @Relation(parentColumn = "exercise_id", entityColumn = "id")
    val exercise:ExerciseDatabase,
    @Relation(parentColumn = "training_cycle_id", entityColumn = "id")
    val trainingCycle:TrainingCycleDatabase
)
