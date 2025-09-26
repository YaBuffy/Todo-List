package com.example.todoapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.unit.dp
import com.example.todoapp.tasksDb.model.Category

@Composable
fun CategorySelector(
    selected: Category?,
    onSelectedCategory: (Category) -> Unit
) {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 20.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Category.values().forEach { category ->
            IconButton(
                onClick = { onSelectedCategory(category) },
                modifier = Modifier
                    .size(50.dp)
                    .background(
                        color = if (category == selected) MaterialTheme.colorScheme.primary
                        else Color.Transparent,
                        shape = MaterialTheme.shapes.extraLarge
                    )
                    .border(
                        width = 2.dp,
                        color = if (category == selected) MaterialTheme.colorScheme.onPrimary
                        else Color.Transparent,
                        shape = MaterialTheme.shapes.extraLarge
                    )
            ) {
                Icon(
                    imageVector = category.icon,
                    contentDescription = category.name,
                    tint = if (category == selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}