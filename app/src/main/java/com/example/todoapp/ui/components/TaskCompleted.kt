package com.example.todoapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todoapp.TODOViewModel
import com.example.todoapp.tasksDb.model.TaskEntity


@Composable
fun TaskCompleted(
    task: TaskEntity,
    modifier: Modifier,
    viewModel: TODOViewModel = hiltViewModel()
){
    Box(modifier = Modifier
        .fillMaxWidth()
        .then(modifier)
    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Row(verticalAlignment = Alignment.CenterVertically){
                Icon(
                    imageVector = task.category.icon,
                    contentDescription = "category",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant)
                Column(modifier = Modifier.padding(start = 15.dp)){
                    Text(
                        text = task.title,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontSize = 20.sp,
                        textDecoration = TextDecoration.LineThrough)
                    Text(
                        text = task.time,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontSize = 15.sp,
                        textDecoration = TextDecoration.LineThrough)
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically){
                IconButton(onClick = {viewModel.delete(task)}) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "category",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant)
                }
                Checkbox(
                    checked = task.isDone,
                    onCheckedChange = {isDone ->
                        viewModel.markAsDone(task = task, isDone = isDone)}
                )
            }

        }
    }
}