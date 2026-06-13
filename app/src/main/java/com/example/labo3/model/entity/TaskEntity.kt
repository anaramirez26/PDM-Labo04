package com.example.labo3.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tasks")
data class TaskEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val endDate: Long = System.currentTimeMillis(),
    val isCompleted: Boolean = false
)