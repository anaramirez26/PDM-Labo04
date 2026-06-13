package com.example.labo3.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.labo3.components.CreateTask
import com.example.labo3.components.TaskCard
import com.example.labo3.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(
    viewModel: TaskViewModel
) {
    var showDialog by remember { mutableStateOf(false) }
    val taskList by viewModel.allTasks.collectAsState(emptyList())

    Scaffold(
        topBar = {
            TopAppBar(title = {Text("Tasks list")})
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {showDialog = true}) {
                Icon(Icons.Default.Add, contentDescription = "Añadir")
            }
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(taskList){
                    task ->
                TaskCard(
                    taskTitle = task.title,
                    taskDescription = task.description,
                    taskEndDate = task.endDate
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
        }

        if (showDialog){
            CreateTask (
                onDismiss = { showDialog = false },
                onTaskCreated = { newTitle, newDescription ->
                    viewModel.addTask(
                        title = newTitle,
                        description = newDescription
                    )
                    showDialog = false
                }
            )
        }

    }
}