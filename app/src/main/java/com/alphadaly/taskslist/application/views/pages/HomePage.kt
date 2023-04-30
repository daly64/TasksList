package com.alphadaly.taskslist.application.views.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.alphadaly.taskslist.application.room.TaskViewModel
import com.alphadaly.taskslist.application.views.components.ApplicationTitle
import com.alphadaly.taskslist.application.views.components.ClearAllTasks
import com.alphadaly.taskslist.application.views.components.TasksInputField
import com.alphadaly.taskslist.application.views.components.TasksList

@Composable
fun HomePage(viewModel: TaskViewModel) {


    val state by viewModel.state.collectAsState()
    val onEvent = viewModel::onEvent

    Column(verticalArrangement = Arrangement.SpaceAround) {
        ApplicationTitle()
        TasksInputField(onEvent)
        TasksList(state, onEvent)
        ClearAllTasks(state, onEvent)

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomePage() {

//    HomePage(viewModel)
}