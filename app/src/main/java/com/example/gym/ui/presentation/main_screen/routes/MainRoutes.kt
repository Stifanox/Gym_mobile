package com.example.gym.ui.presentation.main_screen.routes

sealed class MainRoutes(val route:String){
    object PREFIX:MainRoutes("mainMainScreen")
    object HomeRoute:MainRoutes("homeMainScreen")
}
