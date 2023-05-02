package com.alphadaly.taskslist.application.room.task

import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getAll(): Flow<List<Task>>
    fun getById(id: Int): Flow<Task>
    suspend fun insertTask(task: Task)
    suspend fun updateTask(task: Task)
    suspend fun deleteTask(task: Task)
    suspend fun deleteAll()
}

class OfflineTaskRepository(private val taskDAO: TaskDAO) : TaskRepository {
    override fun getAll(): Flow<List<Task>> = taskDAO.getAll()
    override fun getById(id: Int): Flow<Task> = taskDAO.getById(id)
    override suspend fun insertTask(task: Task) = taskDAO.insertTask(task)
    override suspend fun updateTask(task: Task) = taskDAO.updateTask(task)
    override suspend fun deleteTask(task: Task) = taskDAO.deleteTask(task)
    override suspend fun deleteAll() = taskDAO.deleteAll()
}