package com.alphadaly.taskslist.application.views.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alphadaly.taskslist.application.room.TaskViewModel
import com.alphadaly.taskslist.application.views.components.ClearAllTasks
import com.alphadaly.taskslist.application.views.components.TasksInputField
import com.alphadaly.taskslist.application.views.components.TasksList
import com.alphadaly.taskslist.ui.theme.Typography
import com.alphadaly.taskslist.ui.theme.app_name
import com.alphadaly.taskslist.ui.theme.mainIcon
import com.alphadaly.taskslist.ui.theme.main_color
import com.alphadaly.taskslist.ui.theme.robotoMedium

@Composable
fun HomePage(viewModel: TaskViewModel) {


    val state by viewModel.state.collectAsState()
    val onEvent = viewModel::onEvent

    Column(verticalArrangement = Arrangement.SpaceAround) {
        TopAppBar(
            backgroundColor = main_color,
            elevation = 10.dp,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Icon(
                    imageVector = mainIcon,
                    contentDescription = "application icon",
                    Modifier.size(32.dp),
                    tint = Color.White
                )

                Text(
                    text = app_name,
                    style = Typography.h5,
                    fontFamily = robotoMedium,
                    color = Color.White
                )
            }


        }


//            ApplicationTitle()
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