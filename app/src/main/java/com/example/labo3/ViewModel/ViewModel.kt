package com.example.labo3.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.ViewModelInitializer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.navigation.NavController
import com.example.labo3.Model.Task

class GeneralViewModel: ViewModel() {
    private val _tasks = MutableStateFlow<MutableList< Task>>(mutableListOf())
    val tasks = _tasks.asStateFlow()

    fun addTask(task: Task) {
        _tasks.value = _tasks.value.toMutableList().apply { add(task) }
    }
}