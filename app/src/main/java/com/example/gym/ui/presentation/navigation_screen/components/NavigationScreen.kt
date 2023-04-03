package com.example.gym.ui.presentation.navigation_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.gym.R
import com.example.gym.domain.token.TokenManagerSharedPreferences
import com.example.gym.ui.presentation.exercise_screen.routes.ExerciseRoutes
import com.example.gym.ui.presentation.exercise_screen.routes.exerciseGraph
import com.example.gym.ui.presentation.login_screen.routes.LoginRoutes
import com.example.gym.ui.presentation.login_screen.routes.loginGraph
import com.example.gym.ui.presentation.main_screen.routes.MainRoutes
import com.example.gym.ui.presentation.main_screen.routes.mainGraph
import com.example.gym.ui.presentation.main_screen.screens.home_screen.common_files.MenuItemData
import com.example.gym.ui.presentation.main_screen.screens.home_screen.components.DrawerMenu
import kotlinx.coroutines.launch

@Composable
fun NavigationScreen() {


    val token = TokenManagerSharedPreferences.getTokenFromSharedPreferences(LocalContext.current)

    val startRoute = if (token.isBlank()) {
        LoginRoutes.PREFIX.route
    } else {
        MainRoutes.PREFIX.route
    }
    val navController = rememberNavController()


    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val listOfItems = createListOfItems(navController) {
        scope.launch {
            scaffoldState.drawerState.apply {
                if (isClosed) open() else close()
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = { DrawerMenu(listOfItems = listOfItems) },
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .background(Color(0xff121212))
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .clickable {
                            scope.launch {
                                scaffoldState.drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }
                )
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = startRoute,
            modifier = Modifier.padding(it)
        ) {
            loginGraph(navController)
            mainGraph(navController)
            exerciseGraph(navController)
        }
    }
}

fun createListOfItems(navController: NavController, closeDrawer: () -> Unit): List<MenuItemData> {
    return listOf(
        MenuItemData(
            R.string.login_screen_text, Icons.Default.Login
        ) {
            navController.navigate(LoginRoutes.HomeRoute.route){
                launchSingleTop = true
            }
            closeDrawer()
        },
        MenuItemData(
            R.string.manage_exercises,
            Icons.Default.ListAlt
        ) {
            navController.navigate(ExerciseRoutes.ExerciseList.route){
                launchSingleTop = true
            }
            closeDrawer()
        },
    )
}
