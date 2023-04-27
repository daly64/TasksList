package com.alphadaly.taskslist.application.data

import android.content.Context

class AppDataContainer(private val context: Context ):AppContainer {
    override val tasksRepository: TasksRepository by lazy {
        OfflineTasksRepository(
            TasksDatabase.getDatabase(context).taskDao()
        )
    }
}