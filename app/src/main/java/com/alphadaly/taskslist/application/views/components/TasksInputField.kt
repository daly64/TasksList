package com.alphadaly.taskslist.application.views.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alphadaly.taskslist.application.data.TaskEvent
import com.alphadaly.taskslist.ui.theme.addIcon
import com.alphadaly.taskslist.ui.theme.main_color
import com.alphadaly.taskslist.ui.theme.task_placeholder_text

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TasksInputField(onEvent: (TaskEvent) -> Unit) {
    var textValue by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current



    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        OutlinedTextField(
            singleLine = true,
            value = textValue,
            onValueChange = {
                textValue = it
                onEvent(TaskEvent.SetText(it))
            },
            placeholder = {
                Text(text = task_placeholder_text)
            })
        Button(
            modifier = Modifier
                .height(52.dp)
                .fillMaxWidth(.7f),
            colors = buttonColors(main_color),
            onClick = {
                onEvent(TaskEvent.SaveTask)
                textValue = ""
                keyboardController?.hide()
            },
        ) {
            Icon(
                imageVector = addIcon,
                contentDescription = "add icon",
                tint = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTasksInputField() {
    TasksInputField { }
}