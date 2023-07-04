package com.example.gym.exercise_feature.ui.screens.exercise_add_item.view_models

import androidx.compose.ui.text.toLowerCase
import com.example.gym.data.database.model.ExerciseDatabase
import com.example.gym.data.remote.model.request.ExerciseAddRemote
import com.example.gym.data.remote.model.response.ExerciseRemote
import java.util.*

data class ExerciseItem(
    val exerciseName:String = "",
    val type:Int = 1
)

fun ExerciseItem.toRemote() : ExerciseAddRemote{
    return ExerciseAddRemote(this.exerciseName,this.type)
}

fun ExerciseItem.toDatabase() : ExerciseDatabase{
    //FIXME: setting lowercase in this call might be bad in the future
    return ExerciseDatabase(0,id_remote = null, exerciseName =  this.exerciseName.lowercase(), exerciseType =  this.type)
}