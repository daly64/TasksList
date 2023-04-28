package com.alphadaly.taskslist

import android.app.Application
import com.alphadaly.taskslist.application.data.AppContainer
import com.alphadaly.taskslist.application.data.AppDataContainer

class TasksListApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}