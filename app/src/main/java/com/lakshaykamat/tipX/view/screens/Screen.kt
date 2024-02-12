package com.lakshaykamat.tipX.view.screens

sealed class Screen (val route:String){
    object HomeScreen:Screen("home_screen")
    object InformationScreen:Screen("information_screen")
}