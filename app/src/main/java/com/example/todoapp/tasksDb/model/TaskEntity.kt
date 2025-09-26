package com.example.todoapp.tasksDb.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val category: Category,
    val time: String,
    val dateTime: Long,
    val isDone: Boolean = false
)