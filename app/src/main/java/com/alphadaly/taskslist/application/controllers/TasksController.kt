package com.alphadaly.taskslist.application.controllers

import android.content.Context
import com.alphadaly.taskslist.application.controllers.sqlite.TasksDataBaseSQLiteHandler
import com.alphadaly.taskslist.application.models.Task


class TasksController(context: Context) {
    private val taskDataBaseSQLiteHandler = TasksDataBaseSQLiteHandler(context)

    /*    fun populateTasks() {
            (1..100).map {
                val task = Task(it - 1, "Task $it", false)
                taskDataBaseSQLiteHandler.createTask(task)
            }
        }*/

    /*    fun getTask(id: Int): Task {
            val tasks = getAllTasks()
            return tasks[id - 1]

        }*/
    fun getAllTasks(): ArrayList<Task> = taskDataBaseSQLiteHandler.readAllTasks()

    //    fun getTask(task: Task): Task = taskDataBaseSQLiteHandler.getTask(task)
    fun createTask(task: Task) = taskDataBaseSQLiteHandler.createTask(task)
//    fun updateTask(task: Task) = taskDataBaseSQLiteHandler.updateTask(task)
//    fun validateTask(task: Task) = taskDataBaseSQLiteHandler.validateTask(task)
    fun deleteTask(task: Task) = taskDataBaseSQLiteHandler.deleteTask(task)
//    fun deleteAllTasks() = taskDataBaseSQLiteHandler.deleteAllTasks()

}
