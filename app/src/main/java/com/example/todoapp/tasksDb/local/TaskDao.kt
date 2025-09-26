package com.example.todoapp.tasksDb.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.tasksDb.model.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks WHERE isDone = 1 ORDER BY time DESC")
    fun getCompletedTasks(): Flow<List<TaskEntity>>
    @Query("SELECT * FROM tasks WHERE date(dateTime / 1000, 'unixepoch') = date('now') ORDER BY dateTime ASC")
    fun getTodayTasks(): Flow<List<TaskEntity>>
    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun addTask(task: TaskEntity)
    @Delete
    suspend fun deleteTask(task: TaskEntity)
    @Update
    suspend fun updateTask(task: TaskEntity)
    @Query("Select * from tasks")
    fun getAllTasks(): Flow<List<TaskEntity>>
}