package com.alphadaly.taskslist.application.data

import kotlinx.coroutines.flow.Flow

interface TaskRepositoryInterface {
    fun getAllTasks(): Flow<List<Task>>
    fun getTask(id: Int): Flow<Task?>
    suspend fun insertTask(task: Task)
    suspend fun deleteTask(task: Task)
    suspend fun updateTask(task: Task)
}
class TaskRepository(private val taskDAO: TaskDAO) : TaskRepositoryInterface {
    override fun getAllTasks(): Flow<List<Task>> = taskDAO.getAll()
    override fun getTask(id: Int): Flow<Task?> = taskDAO.getById(id)
    override suspend fun insertTask(task: Task) = taskDAO.insert(task)
    override suspend fun deleteTask(task: Task) = taskDAO.delete(task)
    override suspend fun updateTask(task: Task) = taskDAO.update(task)
}