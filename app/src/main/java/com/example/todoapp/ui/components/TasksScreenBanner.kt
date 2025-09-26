package com.example.todoapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TasksScreenBanner(todayString: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primary)
            .systemBarsPadding()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Text(
            text = todayString,
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 25.sp,
            fontFamily = FontFamily.Serif
        )
        Text(
            text = "My TODO List",
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp),
            fontFamily = FontFamily.Serif
        )
    }
}