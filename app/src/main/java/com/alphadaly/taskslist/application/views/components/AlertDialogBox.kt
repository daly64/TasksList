package com.alphadaly.taskslist.application.views.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.alphadaly.taskslist.application.data.TaskEvent
import com.alphadaly.taskslist.application.data.task.Task
import com.alphadaly.taskslist.ui.theme.main_color
import com.alphadaly.taskslist.ui.theme.robotoMedium
import com.alphadaly.taskslist.ui.theme.robotoRegular
import com.alphadaly.taskslist.ui.theme.text_color1
import com.alphadaly.taskslist.ui.theme.text_color2

@Composable
fun AlertDialogBox(
    DialogText: String,
    openDialog: MutableState<Boolean>,
    onEvent: (event: TaskEvent) -> Unit,
    task: Task = Task("", false),
    onConfirm: () -> Unit,
) {


    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },

            text = {
                Text(
                    text = DialogText,
                    color = text_color1,
                    fontSize = 18.sp,
                    fontFamily = robotoRegular
                )
            },

            confirmButton = {

                TextButton(onClick = {
                    onConfirm()
                    openDialog.value = false
                    if (DialogText == "Delete this task ?") {
                        onEvent(TaskEvent.DeleteTask(task))
                    }
                    if (DialogText == "Delete all tasks ?") {
                        onEvent(TaskEvent.DeleteAll)
                    }


                }) {
                    Text(
                        text = "Yes",
                        color = main_color,
                        fontFamily = robotoMedium,
                        fontSize = 18.sp
                    )
                }

            },
            dismissButton = {
                TextButton(onClick = {
                    openDialog.value = false
                }) {
                    Text(
                        text = "No",
                        color = text_color2,
                        fontFamily = robotoMedium,
                        fontSize = 16.sp
                    )
                }
            },
            backgroundColor = Color.White,
        )
    }
}

@Preview
@Composable
fun PreviewAlertDialogBox() {
    val openDialog = remember { mutableStateOf(true) }
    val task = Task("", false)
    AlertDialogBox("Delete this task ?", openDialog, { }, task) {}
}