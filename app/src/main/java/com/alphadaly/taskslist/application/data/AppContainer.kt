package com.alphadaly.taskslist.application.data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val taskRepository: TaskRepository
}


class AppDataContainer(private val context: Context) : AppContainer {

    override val taskRepository: TaskRepository by lazy {
        TaskRepository(TasksDatabase.getDatabase(context).taskDao())
    }
}