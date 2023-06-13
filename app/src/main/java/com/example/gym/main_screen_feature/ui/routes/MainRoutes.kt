package com.example.gym.main_screen_feature.ui.routes

sealed class MainRoutes(val route:String){
    object PREFIX: MainRoutes("mainMainScreen")
    object HomeRoute: MainRoutes("homeMainScreen")
}
