package com.alphadaly.taskslist.application.room

import com.alphadaly.taskslist.application.room.task.Task

data class TaskState(
    val tasks: List<Task> = emptyList(),
    val text: String = "",
    val done: Boolean = false,
    val isDeletingTask: Boolean = false,

    )