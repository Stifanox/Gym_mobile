package com.example.gym.cycle_feature.ui.routes


sealed class CycleRoutes(val route:String){
    object PREFIX: CycleRoutes("mainCycleScreen")
    object HomeRoute:CycleRoutes("homeCycleScreen")
    object TrainingEditorRoute:CycleRoutes("trainingEditorCycleScreen")
    object CycleAddRoute:CycleRoutes("cycleAddRouteCycleScreen")
}
