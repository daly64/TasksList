package com.alphadaly.taskslist.application.ui

import com.alphadaly.taskslist.application.data.Task

data class TaskUiState(
    val id: Int = 0,
    val text: String = "",
    val done: Boolean = false
)

fun TaskUiState.toTask(): Task = Task(
    id = id,
    text = text,
    done = done
)

fun Task.toTaskUiState(): TaskUiState = TaskUiState(
    id = id,
    text = text,
    done = done
)