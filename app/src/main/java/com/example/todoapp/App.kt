package com.example.todoapp

import android.app.Application
import com.example.todoapp.tasksDb.local.TasksRoomDb
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application()