package com.alphadaly.taskslist.application.data

import kotlinx.coroutines.flow.Flow

class OfflineTasksRepository(private val taskDAO: TaskDAO) : TasksRepository {
    override fun getAllTasks(): Flow<List<Task>> = taskDAO.getAll()
    override fun getTask(id: Int): Flow<Task?> = taskDAO.getById(id)
    override suspend fun insertTask(task: Task) = taskDAO.insert(task)
    override suspend fun deleteTask(task: Task) = taskDAO.delete(task)
    override suspend fun updateTask(task: Task) = taskDAO.update(task)
}