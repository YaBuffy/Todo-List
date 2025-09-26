package com.example.todoapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun BackButton(modifier: Modifier, onBackClick: () ->Unit){
    IconButton(
        onClick = onBackClick,
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.surfaceContainerLow,
                shape = MaterialTheme.shapes.extraLarge)
            .then(modifier))
    {Icon(
        imageVector = Icons.Filled.ArrowBackIosNew,
        contentDescription = "Back",
        tint = MaterialTheme.colorScheme.onSurface)}
}

