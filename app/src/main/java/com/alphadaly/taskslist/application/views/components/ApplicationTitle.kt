package com.alphadaly.taskslist.application.views.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alphadaly.taskslist.ui.theme.*


@Composable
fun ApplicationTitle() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = mainIcon,
            contentDescription = "application icon",
            Modifier.size(32.dp)

        )
        Text(text = app_name, style = Typography.h5, fontFamily = robotoMedium, color = text_color1)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApplicationTitle() {
    ApplicationTitle()
}