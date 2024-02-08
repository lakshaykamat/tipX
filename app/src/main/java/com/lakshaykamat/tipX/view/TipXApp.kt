package com.lakshaykamat.tipX.view

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lakshaykamat.tipX.view.screens.home.HomeScreen
import com.lakshaykamat.tipX.view.screens.information.InformationScreen
import com.lakshaykamat.tipX.view.screens.Screen


@Composable
fun TipXApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Homescreen.toString()
    ) {

        composable(Screen.Homescreen.toString(),
            enterTransition = {
                fadeIn(animationSpec = tween(durationMillis = 500))
            },

            exitTransition = {
                fadeOut(animationSpec = tween(durationMillis = 500))
            }
        ) {
            HomeScreen(nav = navController)
        }
        composable(Screen.InformationScreen.toString(),
            enterTransition = {
                fadeIn(animationSpec = tween(durationMillis = 500))
            },
            exitTransition = {
                fadeOut(animationSpec = tween(durationMillis = 500))
            }) {
            InformationScreen(nav = navController)
        }
    }
}


