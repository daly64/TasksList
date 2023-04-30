package com.alphadaly.taskslist.application.room

import com.alphadaly.taskslist.application.room.task.Task

data class TaskState(
    var tasks: List<Task> = emptyList(),
    var text: String = "",
    val done: Boolean = false,
    val isDeletingTask: Boolean = false,

    )