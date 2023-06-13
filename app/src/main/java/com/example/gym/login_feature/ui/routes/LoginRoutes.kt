package com.example.gym.login_feature.ui.routes


sealed class LoginRoutes(val route:String){
    object PREFIX: LoginRoutes("mainLoginScreen")
    object HomeRoute: LoginRoutes("homeLoginScreen")
    object LoginRoute: LoginRoutes("loginLoginScreen")
    object RegisterRoute: LoginRoutes("registerLoginScreen")
}
