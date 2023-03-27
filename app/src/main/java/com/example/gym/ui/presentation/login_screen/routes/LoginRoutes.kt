package com.example.gym.ui.presentation.login_screen.routes


sealed class LoginRoutes(val route:String){
    object PREFIX:LoginRoutes("loginHomeLoginScreen")
    object HomeRoute:LoginRoutes("homeLoginScreen")
    object LoginRoute:LoginRoutes("loginLoginScreen")
    object RegisterRoute:LoginRoutes("registerLoginScreen")
}
