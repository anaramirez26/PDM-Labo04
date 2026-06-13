package com.example.labo3.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.labo3.model.entity.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: List<TaskEntity>)

    @Query("SELECT * FROM tasks")
    fun getTasks():  Flow<List<TaskEntity>>
}