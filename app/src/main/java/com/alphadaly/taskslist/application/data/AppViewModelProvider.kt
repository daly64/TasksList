package com.alphadaly.taskslist.application.data

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.room.Room
import com.alphadaly.taskslist.application.Global
import com.alphadaly.taskslist.application.data.task.TaskDatabase


object AppViewModelProvider {
    private val db by lazy {
        Room.databaseBuilder(
            Global.context,
            TaskDatabase::class.java,
            "TasksDataBase.db"
        ).build()
    }
    val factory = viewModelFactory {
        initializer {
            TaskViewModel(db.taskDao)
        }
    }
}