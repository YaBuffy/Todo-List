package com.example.todoapp.tasksDb.repository

import com.example.todoapp.tasksDb.local.TaskDao
import com.example.todoapp.tasksDb.model.TaskEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class TaskRepository @Inject constructor(
    private val dao: TaskDao
) {
    fun  getTodayTasks(): Flow<List<TaskEntity>> = dao.getTodayTasks()
    fun  getAllTasks(): Flow<List<TaskEntity>> = dao.getAllTasks()
    fun getCompletedTasks(): Flow<List<TaskEntity>> = dao.getCompletedTasks()
    suspend fun addTask(task: TaskEntity) = dao.addTask(task)
    suspend fun delete(task: TaskEntity) = dao.deleteTask(task)
    suspend fun update(task: TaskEntity) = dao.updateTask(task)
}