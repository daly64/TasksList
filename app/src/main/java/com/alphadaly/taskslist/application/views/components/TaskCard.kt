package com.alphadaly.taskslist.application.views.components

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alphadaly.taskslist.ui.theme.*


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TaskCard(text: String) {

    val openDialog = remember { mutableStateOf(false) }
    AlertDialogBox("Delete this task ?", openDialog) { }

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val sizePx = with(LocalDensity.current) { 48.dp.toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1)
    val swipeableState = rememberSwipeableState(0)

    val swipeable = Modifier
        .swipeable(
            state = swipeableState,
            anchors = anchors,
            thresholds = { _, _ -> FractionalThreshold(0.3f) },
            orientation = Orientation.Horizontal
        )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 7.dp)
            .height(52.dp)
            .then(swipeable),
        backgroundColor = card_background_color,
        elevation = 10.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp)
        ) {
            Text(
                maxLines = 1,
                text = text,
                fontFamily = robotoRegular,
                fontSize = 18.sp,
                letterSpacing = .38.sp,
                color = if (swipeableState.currentValue == 0) text_color1 else text_color2,
                textDecoration = if (swipeableState.currentValue == 0) TextDecoration.None else TextDecoration.LineThrough

            )

            IconButton(onClick = { openDialog.value = true }, interactionSource = interactionSource)
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
    TaskCard("task")
}