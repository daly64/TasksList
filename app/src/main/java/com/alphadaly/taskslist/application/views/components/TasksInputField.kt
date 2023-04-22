package com.alphadaly.taskslist.application.views.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alphadaly.taskslist.ui.theme.addIcon
import com.alphadaly.taskslist.ui.theme.task_placeholder_text

@Composable
fun TasksInputField() {
    var textValue by remember { mutableStateOf("") }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        OutlinedTextField(
            value = textValue,
            onValueChange = { textValue = it },
            placeholder = {
                Text(text = task_placeholder_text)
            })
        Button(
            modifier = Modifier
                .height(52.dp)
                .fillMaxWidth(.7f),
            onClick = {},
        ) {
            Icon(
                imageVector = addIcon,
                contentDescription = "add icon",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTasksInputField() {
    TasksInputField()
}