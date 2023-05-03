package com.alphadaly.taskslist.application.views.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alphadaly.taskslist.ui.theme.*


@Composable
fun ApplicationTitle() {
    TopAppBar(
        backgroundColor = main_color,
        elevation = 10.dp,
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = mainIcon,
                contentDescription = "application icon",
                Modifier.size(42.dp),
                tint = Color.White

            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = app_name,
                style = Typography.h5,
                fontFamily = robotoMedium,
                color = Color.White
            )
        }


    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApplicationTitle() {
    ApplicationTitle()
}