package com.alphadaly.taskslist.application.views.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alphadaly.taskslist.application.room.TaskEvent
import com.alphadaly.taskslist.application.room.TaskState


@Composable
fun TasksList(state: TaskState, onEvent: (event: TaskEvent) -> Unit) {


//    val itemsList by remember { mutableStateOf((1..10).map { "task text $it" }) }


    LazyColumn(
        modifier = Modifier
            .padding(0.dp, 20.dp)
            .fillMaxWidth()
            .fillMaxHeight(.85f),
    ) {
        items(state.tasks.reversed()) { task -> TaskCard(task, onEvent) }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTasksList() {
//    TasksList(TaskState()) { }
}