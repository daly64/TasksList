package com.alphadaly.taskslist.application.views.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alphadaly.taskslist.application.room.TaskEvent
import com.alphadaly.taskslist.application.room.TaskState
import com.alphadaly.taskslist.ui.theme.robotoRegular
import com.alphadaly.taskslist.ui.theme.text_color2


@Composable
fun ClearAllTasks(state: TaskState, onEvent: (event: TaskEvent) -> Unit) {
    val openDialog = remember { mutableStateOf(false) }
    AlertDialogBox("Delete all tasks ?", openDialog, onEvent) {}
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(37.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "you have ${state.tasks.size} pending tasks",
            fontFamily = robotoRegular,
            fontSize = 18.sp,
            letterSpacing = .38.sp,
            color = text_color2
        )
        TextButton(onClick = { openDialog.value = true }) {
            Text(text = "CLEAR ALL")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewClearAllTasks() {
    val state = TaskState()
    ClearAllTasks(state) { }
}