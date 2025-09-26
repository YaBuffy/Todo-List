package com.example.todoapp.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.EditCalendar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todoapp.TODOViewModel
import com.example.todoapp.ui.components.BackButton
import com.example.todoapp.ui.components.CategorySelector
import com.example.todoapp.ui.components.CustomButton
import com.example.todoapp.ui.components.DatePickerModal
import com.example.todoapp.ui.components.TimePickerModal
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(
    viewModel: TODOViewModel = hiltViewModel(),
    onBackClick: () -> Unit ) {
    val title = viewModel.title
    val selectedCategory = viewModel.selectedCategory
    val description = viewModel.description

    var showDatePicker by remember { mutableStateOf(false) }
    var showTimePicker by remember { mutableStateOf(false) }

    val dateText = viewModel.selectedDateTime?.let {
        SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date(it))
    } ?: SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

    val timeText = viewModel.selectedDateTime?.let {
        SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date(it))
    } ?: SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())

    if(showDatePicker){
        DatePickerModal(
            onDateSelected = {millis ->
                viewModel.onDateTimeSelected(millis)
            },
            onDismiss = {showDatePicker = false}
        )
    }
    if(showTimePicker){
        TimePickerModal(
            onConfirm = { state ->
                val calendar = Calendar.getInstance().apply {
                    timeInMillis = viewModel.selectedDateTime ?: System.currentTimeMillis()
                    set(Calendar.HOUR_OF_DAY, state.hour)
                    set(Calendar.MINUTE, state.minute)
                    set(Calendar.SECOND, 0)
                    set(Calendar.MILLISECOND, 0)
                }
                viewModel.onDateTimeSelected(calendar.timeInMillis)
                showTimePicker = false
            },
            onDismiss = { showTimePicker = false }
        )
    }
    val scrollState = rememberScrollState(0)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
            .verticalScroll(scrollState)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.primary)
                .systemBarsPadding()
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            BackButton(
                modifier = Modifier.align(Alignment.CenterStart),
                onBackClick = onBackClick)
            Text(
                text = "Add New Task",
                fontSize = 25.sp,
                fontFamily = FontFamily.Serif,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
        Text(
            text = "Task Title",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .padding(start = 10.dp, top = 20.dp, bottom = 10.dp)
        )
        OutlinedTextField(
            value = title,
            onValueChange = { viewModel.onTitleChange(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        )
        CategorySelector(selected = selectedCategory) {
            viewModel.onSelectedCategory(newCategory = it)
        }
        Text(
            text = "When",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp, bottom = 10.dp)
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            OutlinedButton(
                onClick = {showDatePicker = true},
                shape = RectangleShape,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 5.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically){
                    Text(
                        text = dateText,fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier
                            .padding(top = 10.dp, bottom = 10.dp)
                    )
                    Icon(
                        imageVector = Icons.Filled.EditCalendar,
                        contentDescription = "datePicker",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .padding(top = 10.dp, bottom = 10.dp),)
                }
            }
            OutlinedButton(
                onClick = {showTimePicker = true},
                shape = RectangleShape,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 5.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically){
                    Text(
                        text = timeText,fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier
                            .padding(start = 5.dp, top = 10.dp, bottom = 10.dp)
                    )
                    Icon(
                        imageVector = Icons.Filled.AccessTime,
                        contentDescription = "datePicker",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .padding(end = 5.dp, top = 10.dp, bottom = 10.dp))
                }
            }
        }
        Text(
            text = "Notes",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp, bottom = 10.dp)
        )
        OutlinedTextField(
            value = description,
            onValueChange = { viewModel.onDescriptionChange(it) },
            placeholder = {Text("Add your notes here")},
            minLines = 5,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        CustomButton(
            onClick = {
                viewModel.addTask()
                onBackClick()
            },
            text = "Save"
        )
    }
}