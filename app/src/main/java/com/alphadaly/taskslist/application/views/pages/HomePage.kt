package com.alphadaly.taskslist.application.views.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.alphadaly.taskslist.application.views.components.ApplicationTitle
import com.alphadaly.taskslist.application.views.components.ClearAllTasks
import com.alphadaly.taskslist.application.views.components.TasksInputField
import com.alphadaly.taskslist.application.views.components.TasksList

@Composable
fun HomePage() {
    /*
           */
    Column(verticalArrangement = Arrangement.SpaceAround) {
        ApplicationTitle()
        TasksInputField()
        TasksList()
        ClearAllTasks()

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomePage() {
    HomePage()
}