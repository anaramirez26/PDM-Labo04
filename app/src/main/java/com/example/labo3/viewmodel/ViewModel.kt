package com.example.labo3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.labo3.model.dao.TaskDao
import com.example.labo3.model.entity.TaskEntity
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TaskViewModel(private val taskDao: TaskDao): ViewModel() {

    val allTasks = taskDao.getTasks().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    fun addTask(title: String, description: String) {
        viewModelScope.launch {
            taskDao.insertTask(
                listOf(
                    TaskEntity(
                        title = title,
                        description = description
                    )
                )
            )

        }
    }

    class TaskViewModelFactory( private val taskDao: TaskDao) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return TaskViewModel(taskDao) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}
