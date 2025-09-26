package com.example.todoapp

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.todoapp.tasksDb.local.TaskDao
import com.example.todoapp.tasksDb.local.TasksRoomDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): TasksRoomDb{
            return Room.databaseBuilder(
                app,
                TasksRoomDb::class.java,
                "tasks.db"
            ).build()
    }
    @Provides
    fun provideTaskDao(db: TasksRoomDb): TaskDao  = db.dao
}