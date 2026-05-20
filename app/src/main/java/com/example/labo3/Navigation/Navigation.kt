package com.example.labo3.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.labo3.MainActivity
import com.example.labo3.Screens.Greeting
import com.example.labo3.Screens.HomeScreen


@Preview(showBackground = true)
@Composable
fun Nav(){
    var navController = rememberNavController()

    NavHost(navController, startDestination = "home" ){
        composable("home"){
            HomeScreen(navController)
        }
        composable("main"){
            Greeting()
        }
    }
}