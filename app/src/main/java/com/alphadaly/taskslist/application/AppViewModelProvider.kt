package com.alphadaly.taskslist.application

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.alphadaly.taskslist.TasksListApplication
import com.alphadaly.taskslist.application.ui.TasksListViewModel

object AppViewModelProvider {
    val Factory =
        viewModelFactory {
            initializer {
                TasksListViewModel(tasksListApplication().container.taskRepository)
            }
        }


}

fun CreationExtras.tasksListApplication(): TasksListApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as TasksListApplication)

