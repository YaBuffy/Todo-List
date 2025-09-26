package com.example.todoapp.tasksDb.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.Backpack
import androidx.compose.material.icons.filled.Bed
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Celebration
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.TimeToLeave
import androidx.compose.material.icons.filled.Work
import androidx.compose.ui.graphics.vector.ImageVector

enum class Category(val icon: ImageVector) {
    REMINDER(Icons.Filled.DateRange),
    WORK(Icons.Filled.Work),
    ALARM(Icons.Filled.Alarm),
    TRAVEL(Icons.Filled.Backpack),
    SLEEP(Icons.Filled.Bed),
    LEAVE(Icons.Filled.TimeToLeave),
    READING(Icons.Filled.Book),
    MOVIE(Icons.Filled.Movie),
    CELEBRATION(Icons.Filled.Celebration),
    SPORT(Icons.Filled.EmojiEvents)

}