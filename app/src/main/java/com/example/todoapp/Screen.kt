package com.example.todoapp

sealed class Screen(val route: String) {
    object Tasks: Screen("tasks")
    object AddTask: Screen("add_task")
}