package com.example.gym.ui.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = viewModel()
){

    val isError = homeViewModel.error
    val listOfExercises by homeViewModel.listOfExercises.collectAsState()

    LazyColumn{
        item{
            Button(onClick = { homeViewModel.getAllExercises() }) {
                Text(text = "Wciśnij")
            }
        }
        item {
            Text(text = isError)
        }
        
        items(listOfExercises){
            Text(text = it.exerciseName)
        }
    }
}