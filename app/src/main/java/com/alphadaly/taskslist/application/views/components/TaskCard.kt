package com.alphadaly.taskslist.application.views.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alphadaly.taskslist.application.room.TaskEvent
import com.alphadaly.taskslist.application.room.task.Task
import com.alphadaly.taskslist.ui.theme.card_background_color
import com.alphadaly.taskslist.ui.theme.deleteIcon
import com.alphadaly.taskslist.ui.theme.main_color
import com.alphadaly.taskslist.ui.theme.robotoRegular
import com.alphadaly.taskslist.ui.theme.text_color1
import com.alphadaly.taskslist.ui.theme.text_color2


@Composable
fun TaskCard(task: Task, onEvent: (event: TaskEvent) -> Unit) {


    val openDialog = remember { mutableStateOf(false) }
    AlertDialogBox("Delete this task ?", openDialog, onEvent, task) { }

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()



    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 7.dp)
            .height(52.dp),
        backgroundColor = card_background_color,
        elevation = 10.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp)
        ) {
            Text(
                modifier = Modifier.clickable {
                    task.done = !task.done
                    onEvent(TaskEvent.UpdateTask(task))
                },
                maxLines = 1,
                text = task.text,
                fontFamily = robotoRegular,
                fontSize = 18.sp,
                letterSpacing = .38.sp,
                color = if (task.done) text_color2 else text_color1,
                textDecoration = if (task.done) TextDecoration.LineThrough else TextDecoration.None

            )

            IconButton(
                onClick = { openDialog.value = true },
                interactionSource = interactionSource
            )
            {
                Icon(
                    modifier = Modifier
                        .size(32.dp),
                    imageVector = deleteIcon,
                    contentDescription = null,
                    tint = if (isPressed) main_color else text_color2
                )
            }
        }


    }

}


@Preview(showBackground = true)
@Composable
fun PreviewTaskCard() {
    val task = Task("", false)
//    TaskCard(task) { }
}