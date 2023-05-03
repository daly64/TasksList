package com.alphadaly.taskslist.application.data

import com.alphadaly.taskslist.application.data.task.Task

data class TaskState(
    var tasks: List<Task> = emptyList(),
    var text: String = "",
    val done: Boolean = false,
    val isDeletingTask: Boolean = false,

    )