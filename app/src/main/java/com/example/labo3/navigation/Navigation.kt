package com.example.labo3.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.labo3.screens.Greeting
import com.example.labo3.screens.HomeScreen
import com.example.labo3.viewmodel.TaskViewModel


@Composable
fun Nav(viewModel: TaskViewModel){
    val navController = rememberNavController()
    NavHost(navController, startDestination = "main_screen" ){
        composable("main_screen"){
            HomeScreen(
                onNavigateMenu = { rutaDestino -> navController.navigate(rutaDestino) }
            )
        }
        composable("tasks_screen"){
            Greeting(
                viewModel = viewModel
            )
        }
    }
}