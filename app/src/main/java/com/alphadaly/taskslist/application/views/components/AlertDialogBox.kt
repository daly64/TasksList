package com.alphadaly.taskslist.application.views.components

import android.widget.Toast
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.alphadaly.taskslist.ui.theme.main_color
import com.alphadaly.taskslist.ui.theme.robotoMedium
import com.alphadaly.taskslist.ui.theme.robotoRegular
import com.alphadaly.taskslist.ui.theme.text_color1
import com.alphadaly.taskslist.ui.theme.text_color2

@Composable
fun AlertDialogBox(
    DialogText: String,
    openDialog: MutableState<Boolean>,
    onConfirm: () -> Unit,
) {
    val context = LocalContext.current
//    val openDialog = remember { mutableStateOf(true) }

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
                    Toast.makeText(context, "Yes Button Click", Toast.LENGTH_SHORT).show()
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
                    Toast.makeText(context, "No Button Click", Toast.LENGTH_SHORT).show()
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
    AlertDialogBox("Delete this task ?", openDialog) {}
}