package com.alphadaly.taskslist.application.data

import com.alphadaly.taskslist.application.data.task.Task

sealed interface TaskEvent {
    object SaveTask : TaskEvent
    object DeleteAll : TaskEvent
    data class CreateTask(val task: Task) : TaskEvent
    data class UpdateTask(val task: Task) : TaskEvent
    data class DeleteTask(val task: Task) : TaskEvent
    data class SetText(val text: String) : TaskEvent
    data class SetDone(val done: Boolean) : TaskEvent
    object ShowDialog : TaskEvent
    object HideDialog : TaskEvent

}