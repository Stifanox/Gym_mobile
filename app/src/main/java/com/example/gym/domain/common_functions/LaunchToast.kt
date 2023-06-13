package com.example.gym.domain.common_functions

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.gym.domain.fetching_status.FetchingStatus

@Composable
fun launchToast(context:Context, dataToObserve:FetchingStatus){

    LaunchedEffect(dataToObserve) {
        if (dataToObserve is FetchingStatus.Error) {
            Toast.makeText(
                context,
                dataToObserve.error,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}