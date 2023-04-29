package com.alphadaly.taskslist.application.views.components

import android.content.Context
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.Room
import com.alphadaly.taskslist.application.room.TaskViewModel
import com.alphadaly.taskslist.application.room.task.TaskDatabase

class TaskData(context: Context) {
    private val db by lazy {
        Room.databaseBuilder(
            context,
            TaskDatabase::class.java,
            "TasksDataBase.db"
        ).build()
    }
    val viewModel = TaskViewModel(db.dao)
}

@Composable
fun TasksList() {


//    val itemsList by remember { mutableStateOf((1..10).map { "task text $it" }) }

    val context = LocalContext.current
    val state by TaskData(context).viewModel.state.collectAsState()
//    val onEvent = TaskData(context).viewModel::onEvent
    LazyColumn(
        modifier = Modifier
            .padding(0.dp, 20.dp)
            .fillMaxWidth()
            .fillMaxHeight(.85f),
    ) {
        items(state.tasks) { task -> TaskCard(task) }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTasksList() {
    TasksList()
}