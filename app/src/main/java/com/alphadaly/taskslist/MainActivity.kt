package com.alphadaly.taskslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alphadaly.taskslist.application.views.components.ApplicationTitle
import com.alphadaly.taskslist.application.views.components.ClearAllTasks
import com.alphadaly.taskslist.application.views.components.TaskCard
import com.alphadaly.taskslist.application.views.components.TasksInputField
import com.alphadaly.taskslist.application.views.components.TasksList
import com.alphadaly.taskslist.application.views.pages.HomePage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomePage()
        }
    }
}

