package com.example.todoapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todoapp.tasksDb.model.Category
import com.example.todoapp.tasksDb.model.TaskEntity
import com.example.todoapp.tasksDb.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class TODOViewModel @Inject constructor(
    private val repository: TaskRepository
): ViewModel() {

    //Add New Task in AddTaskScreen
    var title by mutableStateOf("")
        private set
    var description by mutableStateOf("")
        private set
    var selectedDateTime by mutableStateOf<Long>(System.currentTimeMillis())
        private set
    var selectedCategory by mutableStateOf<Category>(Category.REMINDER)
        private set

    fun onTitleChange(newTitle: String){
        title = newTitle
    }

    fun onDescriptionChange(newDescription: String){
        description = newDescription
    }

    fun onDateTimeSelected(millis: Long){
        selectedDateTime = millis
    }

    fun onSelectedCategory(newCategory: Category){
        selectedCategory = newCategory
    }

    fun addTask(){
        val time = selectedDateTime?.let {
            SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date(it))
        } ?: SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
        val task = TaskEntity(
            title = title,
            description = description,
            category = selectedCategory,
            time = time,
            dateTime = selectedDateTime
        )

        viewModelScope.launch {
            repository.addTask(task)
        }
    }

    //for TasksScreen

    val calendar = Calendar.getInstance()
    val sdf = SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH)
    val todayString = sdf.format(calendar.time) //today's date

    val completedTask: StateFlow<List<TaskEntity>> = repository
        .getCompletedTasks()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
    val todayTasks: StateFlow<List<TaskEntity>> = repository
        .getTodayTasks()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun markAsDone(task: TaskEntity, isDone: Boolean){
        viewModelScope.launch {
            repository.update(task.copy(isDone = isDone))
        }
    }
    fun delete(task: TaskEntity){
        viewModelScope.launch {
            repository.delete(task)
        }
    }
}