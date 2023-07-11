package com.example.gym.cycle_feature.ui.screens.training_editor_screen.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun TrainingEditor(nameOfCycle:String?) {

    LaunchedEffect(key1 = null){

    }

    //TODO: add nice way of adding training days
    Text(nameOfCycle.toString())
}