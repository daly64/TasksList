package com.alphadaly.taskslist.application.room

import com.alphadaly.taskslist.application.room.task.Task

sealed interface TaskEvent {
    object SaveTask : TaskEvent
    object DeleteAll : TaskEvent
    data class DeleteTask(val task: Task) : TaskEvent
    data class SetText(val text: String) : TaskEvent
    data class SetDone(val done: Boolean) : TaskEvent
    object ShowDialog : TaskEvent
    object HideDialog : TaskEvent

}