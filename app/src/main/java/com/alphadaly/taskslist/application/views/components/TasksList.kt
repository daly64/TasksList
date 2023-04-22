package com.alphadaly.taskslist.application.views.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TasksList() {
    val itemsList by remember { mutableStateOf((1..10).map { "task text $it" }) }

    LazyColumn(
        modifier = Modifier
            .padding(0.dp,20.dp)
            .fillMaxWidth()
            .fillMaxHeight(.85f),
    ) {
        items(itemsList) { item -> TaskCard(item) }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTasksList() {
    TasksList()
}