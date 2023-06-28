package com.example.gym.exercise_feature.ui.screens.exercise_add_item.view_models

import com.example.gym.data.database.model.ExerciseDatabase
import com.example.gym.data.remote.model.request.ExerciseAddRemote
import com.example.gym.data.remote.model.response.ExerciseRemote

data class ExerciseItem(
    val exerciseName:String = "",
    val type:Int = 1
)

fun ExerciseItem.toRemote() : ExerciseAddRemote{
    return ExerciseAddRemote(this.exerciseName,this.type)
}

fun ExerciseItem.toDatabase() : ExerciseDatabase{
    return ExerciseDatabase(0,id_remote = null, exerciseName =  this.exerciseName, exerciseType =  this.type)
}