package com.example.todoapp.tasksDb.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapp.tasksDb.model.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class TasksRoomDb : RoomDatabase() {
    abstract val dao: TaskDao
}