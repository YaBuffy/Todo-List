package com.example.todoapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todoapp.ui.screens.AddTaskScreen
import com.example.todoapp.ui.screens.TasksScreen

@Composable
fun AppNavGraph(navController: NavHostController){
    NavHost(
        navController,
        startDestination = Screen.Tasks.route
    ){
        composable(Screen.Tasks.route){
            TasksScreen(onAddTasksClick = {navController.navigate(Screen.AddTask.route)})
        }
        composable(Screen.AddTask.route){
            AddTaskScreen(onBackClick = {navController.popBackStack()})
        }
    }
}