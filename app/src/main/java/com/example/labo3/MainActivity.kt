package com.example.labo3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.labo3.model.database.TaskDatabase
import com.example.labo3.navigation.Nav
import com.example.labo3.ui.theme.Labo3Theme
import com.example.labo3.viewmodel.TaskViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labo3Theme {
                val context = LocalContext.current

                val database = TaskDatabase.getDatabase(context)
                val taskDao = database.taskDao()
                val viewModel: TaskViewModel = viewModel (
                    factory = TaskViewModel.TaskViewModelFactory(taskDao)
                )

                Nav(viewModel = viewModel)
            }
        }
    }
}