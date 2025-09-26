package com.example.todoapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todoapp.TODOViewModel
//import com.example.todoapp.ui.components.CompletedTasksBox
import com.example.todoapp.ui.components.CustomButton
import com.example.todoapp.ui.components.TaskCompleted
import com.example.todoapp.ui.components.TaskUncompleted
import com.example.todoapp.ui.components.TasksScreenBanner
//import com.example.todoapp.ui.components.TodayTasksBox

@Composable
fun TasksScreen(
    viewModel: TODOViewModel = hiltViewModel(),
    onAddTasksClick: ()-> Unit
){
    val todayTasks by viewModel.todayTasks.collectAsState()
    val completedTasks by viewModel.completedTask.collectAsState()
    val todayString = viewModel.todayString
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
        bottomBar = {CustomButton(
            onClick = onAddTasksClick,
            text = "Add New Note")}
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = innerPadding.calculateBottomPadding())
        ) {
            TasksScreenBanner(todayString)

            LazyColumn(modifier = Modifier.fillMaxSize().padding(top = 15.dp), contentPadding = PaddingValues(horizontal = 15.dp)) {
                itemsIndexed(todayTasks){index, task->
                    val shape = when(index){
                        0 -> RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                        todayTasks.lastIndex -> RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                        else -> RectangleShape
                    }
                    TaskUncompleted(
                        task,
                        modifier = Modifier
                            .clip(shape = shape)
                            .background(MaterialTheme.colorScheme.surfaceContainerHigh)
                    )
                }
                item{
                    Text(
                        text = "Completed",
                        modifier = Modifier.padding(10.dp),
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 25.sp,
                        fontFamily = FontFamily.Serif,
                        style = MaterialTheme.typography.headlineLarge,
                    )
                }
                itemsIndexed(completedTasks){index, task->
                    val shape = when(index){
                        0 -> RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                        completedTasks.lastIndex -> RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                        else -> RectangleShape
                    }
                    TaskCompleted(
                        task,
                        modifier = Modifier
                            .clip(shape = shape)
                            .background(MaterialTheme.colorScheme.surfaceContainerHigh)
                    )
                }
            }
//            TodayTasksBox(todayTasks)
//            CompletedTasksBox(completedTasks)
        }
    }
}