package com.example.gym.cycle_feature.ui.screens.cycle_manager_screen.componenets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.gym.domain.connection.ConnectivityObserver

@Composable
fun CycleListItem(
    removeFromDatabase:()->Unit,
    removeFromRemote:()->Unit,
    name:String,
    isConnectedToNetwork:ConnectivityObserver.Status
){
    var howManyTimesClicked by remember {
        mutableStateOf(0)
    }

    Row{
        Text(text = name)
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = null,
            modifier = Modifier.clickable { removeFromDatabase() })

        if (isConnectedToNetwork == ConnectivityObserver.Status.Available) {
            Icon(
                imageVector = Icons.Default.DeleteForever,
                //FIXME: wont work in lightmode
                tint = if(howManyTimesClicked==1) Color.Red else Color.White,
                contentDescription = null,
                modifier = Modifier.clickable {
                    howManyTimesClicked++
                    if(howManyTimesClicked < 2) return@clickable
                    removeFromRemote()
                })
        }
    }

}