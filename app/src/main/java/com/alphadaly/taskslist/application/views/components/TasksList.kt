package com.alphadaly.taskslist.application.views.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alphadaly.taskslist.application.AppViewModelProvider
import com.alphadaly.taskslist.application.ui.TasksListViewModel

@Composable
fun TasksList(
    viewModel: TasksListViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
//    val itemsList by remember { mutableStateOf((1..10).map { "task text $it" }) }
    val tasksListUiState by viewModel.tasksListUiState.collectAsState()

    Log.i("TAG", "TasksList: ${tasksListUiState.tasksList}")

    LazyColumn(
        modifier = Modifier
            .padding(0.dp, 20.dp)
            .fillMaxWidth()
            .fillMaxHeight(.85f),
    ) {
        items(tasksListUiState.tasksList) { task -> TaskCard(task.text) }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTasksList() {
    TasksList()
}