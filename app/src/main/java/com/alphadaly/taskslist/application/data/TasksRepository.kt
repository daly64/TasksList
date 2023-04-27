package com.alphadaly.taskslist.application.data

import kotlinx.coroutines.flow.Flow

interface TasksRepository {
    fun getAllTasks(): Flow<List<Task>>
    fun getTask(id: Int): Flow<Task?>
    suspend fun insertTask(task: Task)
    suspend fun deleteTask(task: Task)
    suspend fun updateTask(task: Task)
}